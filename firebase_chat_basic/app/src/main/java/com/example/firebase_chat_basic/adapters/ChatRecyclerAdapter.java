package com.example.firebase_chat_basic.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase_chat_basic.databinding.ItemFragmentChatBinding;
import com.example.firebase_chat_basic.view.activity.ChatRoomActivity;
import com.example.firebase_chat_basic.viewModel.ChatViewModel;

/**
 * [ChatRecyclerAdapter]
 * <p>
 * This adapter is that for "ChatFragment".
 * All data binding is consist of "ChatViewModel".
 */

public class ChatRecyclerAdapter extends RecyclerView.Adapter<ChatRecyclerAdapter.CustomChatViewHolder> {
    private final ChatViewModel chatViewModel;


    public ChatRecyclerAdapter(ChatViewModel chatViewModel) {
        this.chatViewModel = chatViewModel;
    }

    @NonNull
    @Override
    public ChatRecyclerAdapter.CustomChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFragmentChatBinding itemFragmentChatBinding = ItemFragmentChatBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CustomChatViewHolder(itemFragmentChatBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatRecyclerAdapter.CustomChatViewHolder holder, int position) {
        // connect to in chatViewModel method
        holder.bind(chatViewModel, position);

    }

    @Override
    public int getItemCount() {
        // return the method(getChatListModelList) in the chatViewModel
        return chatViewModel.get_chat_list().size();
    }


    // custom "ChatViewHolder"
    // ItemFragmentChatBinding == item_fragment_chat

    public class CustomChatViewHolder extends RecyclerView.ViewHolder {
        ItemFragmentChatBinding itemFragmentChatBinding;

        public CustomChatViewHolder(@NonNull ItemFragmentChatBinding itemFragmentChatBinding) {
            super(itemFragmentChatBinding.getRoot());
            this.itemFragmentChatBinding = itemFragmentChatBinding;

        }

        public void bind(ChatViewModel chatViewModel, int pos) {
            itemFragmentChatBinding.setChatViewModel(chatViewModel);
            itemFragmentChatBinding.setPos(pos);
            itemFragmentChatBinding.executePendingBindings();

            // 이름, uid, 그 사람으 ud
            itemFragmentChatBinding.chatItemLayout.setOnClickListener(view -> {
                Intent intoChatRoomActivity = new Intent(view.getContext(), ChatRoomActivity.class);
                intoChatRoomActivity.putExtra("getOtherName", chatViewModel.get_user_name(pos));
                intoChatRoomActivity.putExtra("getChatKey", chatViewModel.get_chat_key(pos));
                intoChatRoomActivity.putExtra("getCurrentMyUID", chatViewModel.get_my_uid(pos));
                intoChatRoomActivity.putExtra("getOtherUID", chatViewModel.get_other_uid(pos));
                view.getContext().startActivity(intoChatRoomActivity);
                Log.d("이거 되나", "");
            });
        }
    }
}
