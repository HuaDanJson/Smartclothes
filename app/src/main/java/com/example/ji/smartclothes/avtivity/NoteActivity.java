package com.example.ji.smartclothes.avtivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.example.ji.smartclothes.R;
import com.example.ji.smartclothes.adapter.NoteAdapter;
import com.example.ji.smartclothes.base.BaseActivity;
import com.example.ji.smartclothes.bean.Note;
import com.example.ji.smartclothes.utils.ToastHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class NoteActivity extends BaseActivity {

    @BindView(R.id.tv_title_note_activity) TextView mTitle;
    @BindView(R.id.tv_send_note_activity) TextView mSendNote;
    @BindView(R.id.rv_note_activity) RecyclerView mRecyclerView;

    List<Note> noteList = new ArrayList<>();
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        ButterKnife.bind(this);
        getMediaData();
    }

    public void getMediaData() {
        BmobQuery<Note> query = new BmobQuery<Note>();
        // 按时间降序查询
        query.order("-createdAt");
        query.setLimit(20);
        //从服务器获取衣服图片 集合 Arraylist
        query.findObjects(new FindListener<Note>() {
            @Override
            public void done(List<Note> list, BmobException e) {
                if (e == null) {
                    noteList = list;
                    if (noteList.size() == 0) {
                        ToastHelper.showShortMessage("还未有编写的帖子");
                    } else {
                        if (mRecyclerView != null) {
                            mRecyclerView.setLayoutManager(new LinearLayoutManager(NoteActivity.this));
                            noteAdapter = new NoteAdapter(noteList, NoteActivity.this);
                            mRecyclerView.setAdapter(noteAdapter);
                        }
                    }
                } else {
                    ToastHelper.showShortMessage("获取数据失败");

                    LogUtils.e("NoteActivity e ="+e);
                }

            }
        });
    }

    @OnClick(R.id.tv_send_note_activity)
    public void senNote() {
        toActivity(SendNoteActivity.class);
    }
}
