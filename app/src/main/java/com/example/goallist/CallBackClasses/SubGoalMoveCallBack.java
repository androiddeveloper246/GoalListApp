package com.example.goallist.CallBackClasses;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goallist.DragDropInterfaces.DragDropCallBacks;

public class SubGoalMoveCallBack extends ItemTouchHelper.Callback {

    Context context;
    DragDropCallBacks callBackAdapter;

    public SubGoalMoveCallBack(Context context,DragDropCallBacks subGoalCallBack){
        this.context = context;
        callBackAdapter = subGoalCallBack;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

        int movementFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        return makeMovementFlags(movementFlags, 0);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

        callBackAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) { }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
    }



}
