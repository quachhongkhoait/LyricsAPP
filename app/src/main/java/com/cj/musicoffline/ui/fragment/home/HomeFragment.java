package com.cj.musicoffline.ui.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cj.musicoffline.R;
import com.cj.musicoffline.model.AudioModel;
import com.cj.musicoffline.model.PlayListModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    AdapterNew adapter;
    RecyclerView mRecyclerView;
    AdapterPL adapterPL;
    RecyclerView mRecyclerViewPL;
    private List<AudioModel> arrayList = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    private List<PlayListModel> arrayListPL = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup(view);
        getMusicNew();
        getPlayList();
    }

    private void getPlayList() {
        arrayListPL.add(new PlayListModel(1," Tổng Hợp Playlist Đen Vâu", 1));
        arrayListPL.add(new PlayListModel(1," Trời hôm nay nhiều mây cực!", 1));
        arrayListPL.add(new PlayListModel(3," Tổng Hợp Playlist Lê Bảo Bình", 3));
        arrayListPL.add(new PlayListModel(1,"Ngày Khác Lạ", 1));
        arrayListPL.add(new PlayListModel(1,"Mười Năm", 1));
        arrayListPL.add(new PlayListModel(1,"Anh Đếch Cần Gì Ngoài Em", 1));
        arrayListPL.add(new PlayListModel(1,"Cảm ơn", 1));
        arrayListPL.add(new PlayListModel(1,"Đi Theo Bóng Mặt Trời", 1));
    }

    private void getMusicNew() {
        arrayList.add(new AudioModel("content://media/external/audio/media/2325", "luan hoi co phong loi viet lee phu quy nhac co phong thu gian ru ngu 0R4zCXMByoK-gucZLRg", "249234", "1", "music"));
        arrayList.add(new AudioModel("content://media/external/audio/media/103363", "N咊 Duy麩", "335024", "3", "N咊 Duy麩 (Single)"));
        arrayList.add(new AudioModel("content://media/external/audio/media/2326", "mot giac mong xua co phong loi viet lee phu quy nhac co phong em diu ru ngu 4-pcBXMByoK-gucZ93gL", "177084", "1", "music"));
        arrayList.add(new AudioModel("content://media/external/audio/media/37896", "Không Thuộc Về", "104315", "2", "NhacCuaTui.com"));
        arrayList.add(new AudioModel("content://media/external/audio/media/31465", "y2mate.com - [TIKTOK] PHÁ KÉN _ Ca Khúc Chủ Đề Đấu La Đại Lục - [Cover lời Việt] - Tiểu Muội Màn Thầu", "210887", "1", "music"));
        arrayList.add(new AudioModel("content://media/external/audio/media/2332", "lu khach qua thoi gian remix tuan nguyen thieu gia x phong tung 1503364", "198922", "1", "music"));

    }

    private void setup(View view) {
        mRecyclerView = view.findViewById(R.id.recycleView_recommended);
        mRecyclerViewPL = view.findViewById(R.id.recycleView_Playlist);

        mLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new AdapterNew(getContext(), arrayList, new AdapterNew.OnClickItemMusicListener() {
            @Override
            public void onclickItem(int position) {

            }
        });
        mRecyclerView.setAdapter(adapter);

        mLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        mRecyclerViewPL.setLayoutManager(mLayoutManager);
        mRecyclerViewPL.setItemAnimator(new DefaultItemAnimator());
        adapterPL = new AdapterPL(getContext(), arrayListPL, new AdapterPL.OnClickItemMusicListener() {
            @Override
            public void onClickOpen(int pos, int id) {

            }

            @Override
            public void onClickDelete(int pos, int id) {

            }
        });
        mRecyclerViewPL.setAdapter(adapterPL);
    }
}