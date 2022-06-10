package com.example.firebase_chat_basic.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebase_chat_basic.databinding.ItemFragmentChatBinding;
import com.example.firebase_chat_basic.view.activity.ChatRoomActivity;
import com.example.firebase_chat_basic.viewModel.ChatRoomViewModel;
import com.example.firebase_chat_basic.viewModel.ChatViewModel;

/**
 * [ChatRecyclerAdapter]
 *
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
        return chatViewModel.getChatListModelList() == null ?
                0 : chatViewModel.getChatListModelList().size();

    }


    // custom "ChatViewHolder"
    // ItemFragmentChatBinding == item_fragment_chat

    public class CustomChatViewHolder extends RecyclerView.ViewHolder {
        ItemFragmentChatBinding itemFragmentChatBinding;

        public CustomChatViewHolder(@NonNull ItemFragmentChatBinding itemFragmentChatBinding) {
            super(itemFragmentChatBinding.getRoot());
            this.itemFragmentChatBinding = itemFragmentChatBinding;

        }

        public void bind(ChatViewModel chatViewModel, int pos){
            itemFragmentChatBinding.setChatViewModel(chatViewModel);
            itemFragmentChatBinding.setPos(pos);
            itemFragmentChatBinding.executePendingBindings();

            itemFragmentChatBinding.chatItemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), ChatRoomActivity.class);
                    intent.putExtra("dName", chatViewModel.getName(pos));
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
