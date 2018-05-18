package com.primeyz.padcassignment1.fragments;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.primeyz.padcassignment1.R;
import com.primeyz.padcassignment1.interfaces.RecyclerAddClickListener;
import com.primeyz.padcassignment1.adapters.ItemRVAdapter;
import com.primeyz.padcassignment1.adapters.PlayListRVAdapter;
import com.primeyz.padcassignment1.adapters.TopicRVAdapter;
import com.primeyz.padcassignment1.models.ItemModel;
import com.primeyz.padcassignment1.models.TopicModel;

import java.util.ArrayList;

/**
 * Created by yepyaesonetun on 5/14/18.
 **/

@SuppressWarnings("all")
public class SeriesFragment extends Fragment implements RecyclerAddClickListener{

    private RecyclerView rvStartList,rvMyPlayList, rvHealthyMind, rvNewOnSimpleHabit, rvMostPopular, rvAllTopic;

    private ArrayList<ItemModel> itemStartList, itemHealthyList, itemNewOnSimpleHabitList, itemMostPopularList, itemClickedPlayList;
    private CardView cvSuggestionCard;
    private TextView tvPlayListTitle;

    public SeriesFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_series, container, false);
        init(view);

        return view;

    }

    private void init(View view) {

        cvSuggestionCard = view.findViewById(R.id.cv_suggestion);

        rvStartList = view.findViewById(R.id.rv_start);
        rvMyPlayList = view.findViewById(R.id.rv_my_playlist);
        rvHealthyMind = view.findViewById(R.id.rv_healthy_min);
        rvNewOnSimpleHabit = view.findViewById(R.id.rv_new_on_simple_habit);
        rvMostPopular = view.findViewById(R.id.rv_most_popular);
        rvAllTopic = view.findViewById(R.id.rv_all_topic);

        tvPlayListTitle = view.findViewById(R.id.tv_playlist);

        rvStartList.setNestedScrollingEnabled(false);
        rvMyPlayList.setNestedScrollingEnabled(false);
        rvHealthyMind.setNestedScrollingEnabled(false);
        rvNewOnSimpleHabit.setNestedScrollingEnabled(false);
        rvMostPopular.setNestedScrollingEnabled(false);
        rvAllTopic.setNestedScrollingEnabled(false);

        itemClickedPlayList = new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setSuggestionCard();
        setHealthyMindList();
        setNewOnSimpleHabitList();
        setMostPopularList();
        setTopicList();

        handlePlayList();

        super.onViewCreated(view, savedInstanceState);
    }

    private void handlePlayList() {
        if (itemClickedPlayList.size() != 0){
            tvPlayListTitle.setVisibility(View.VISIBLE);
            rvMyPlayList.setVisibility(View.VISIBLE);
            LinearLayoutManager lmHorizontal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            rvMyPlayList.setLayoutManager(lmHorizontal);
            PlayListRVAdapter adapter = new PlayListRVAdapter(getContext(), R.layout.item_card, itemClickedPlayList);
            adapter.setListener(this);
            rvMyPlayList.setAdapter(adapter);

        }else {
            tvPlayListTitle.setVisibility(View.GONE);
            rvMyPlayList.setVisibility(View.GONE);
        }
    }

    private void setSuggestionCard() {
        itemStartList = new ArrayList<>();
        itemStartList.add(new ItemModel(R.drawable.sample,"Simple Habit Starter","5 min"));
        LinearLayoutManager lmHorizontal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvStartList.setLayoutManager(lmHorizontal);
        ItemRVAdapter adapter = new ItemRVAdapter(getContext(), R.layout.content_series_recomanded, itemStartList);
        adapter.setListener(this);
        rvStartList.setAdapter(adapter);
    }

    private int getScreenWidth() {

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.x;
    }

    private void setMostPopularList() {
        itemMostPopularList = new ArrayList<>();
        itemMostPopularList.add(new ItemModel(R.drawable.s_city, "Roaming in the City", "5 min"));
        itemMostPopularList.add(new ItemModel(R.drawable.s_silent, "Release Blame", "15 min"));
        itemMostPopularList.add(new ItemModel(R.drawable.s_couple, "Healthy Couple", "5 min"));
        itemMostPopularList.add(new ItemModel(R.drawable.s_claim, "Staying Clam", "10 min"));
        LinearLayoutManager lmHorizontal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvMostPopular.setLayoutManager(lmHorizontal);
        ItemRVAdapter adapter = new ItemRVAdapter(getContext(), R.layout.item_card, itemMostPopularList);
        adapter.setListener(this);
        rvMostPopular.setAdapter(adapter);

    }

    private void setNewOnSimpleHabitList() {
        itemNewOnSimpleHabitList = new ArrayList<>();
        itemNewOnSimpleHabitList.add(new ItemModel(R.drawable.sample, "Mini Retreat Form Moms", "5 min"));
        itemNewOnSimpleHabitList.add(new ItemModel(R.drawable.s_4, "Guided Naptime", "10 min"));
        itemNewOnSimpleHabitList.add(new ItemModel(R.drawable.s_7, "Gratitude For Moms", "5 min"));
        itemNewOnSimpleHabitList.add(new ItemModel(R.drawable.loch, "Kindness at the Gym", "5 min"));
        itemNewOnSimpleHabitList.add(new ItemModel(R.drawable.s_6, "Be More Self Aware", "5 min"));

        LinearLayoutManager lmHorizontal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvNewOnSimpleHabit.setLayoutManager(lmHorizontal);
        ItemRVAdapter adapter = new ItemRVAdapter(getContext(), R.layout.item_card, itemNewOnSimpleHabitList);
        adapter.setListener(this);
        rvNewOnSimpleHabit.setAdapter(adapter);

    }

    private void setHealthyMindList() {
        itemHealthyList = new ArrayList<>();
        itemHealthyList.add(new ItemModel(R.drawable.s_1, "Dealing with Bullies", "5 min"));
        itemHealthyList.add(new ItemModel(R.drawable.s_2, "Thought Detox", "5.10.20 min"));
        itemHealthyList.add(new ItemModel(R.drawable.s_3, "Panic Attack Relief", "5.10 min"));
        itemHealthyList.add(new ItemModel(R.drawable.s_4, "Addiction and Craving", "10.20 min"));
        itemHealthyList.add(new ItemModel(R.drawable.s_5, "Heal From Trauma", "5 min"));

        LinearLayoutManager lmHorizontal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvHealthyMind.setLayoutManager(lmHorizontal);
        ItemRVAdapter adapter = new ItemRVAdapter(getContext(), R.layout.item_card, itemHealthyList);
        adapter.setListener(this);
        rvHealthyMind.setAdapter(adapter);
    }

    private void setTopicList() {
        ArrayList<TopicModel> topicList = new ArrayList<>();
        topicList.add(new TopicModel(R.drawable.ic_flame, R.drawable.loch, "Basics", "Learn meditation fundamentals"));
        topicList.add(new TopicModel(R.drawable.ic_leaf, R.drawable.mountain, "Relax", "Unwind and relieve stress"));
        topicList.add(new TopicModel(R.drawable.ic_sleep_mode, R.drawable.nature_1, "Sleep", "Reset effortlessly in deep sleep"));
        topicList.add(new TopicModel(R.drawable.ic_idea, R.drawable.nature_2, "Focus", "Clear the mind for high performance"));
        topicList.add(new TopicModel(R.drawable.ic_heart, R.drawable.nature_3, "Well-being", "inspire joy,abundance , and purpose"));
        topicList.add(new TopicModel(R.drawable.ic_road, R.drawable.lemon_1, "Resilience", "Face challenges for strength"));
        topicList.add(new TopicModel(R.drawable.ic_apple, R.drawable.trees, "Health", "Care of your mind and body"));

        LinearLayoutManager lmVertical = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvAllTopic.setLayoutManager(lmVertical);
        rvAllTopic.setAdapter(new TopicRVAdapter(getContext(), R.layout.item_topic, topicList));
    }

    @Override
    public void addClicked(ItemModel model) {
        itemClickedPlayList.add(model);
        handlePlayList();
    }
}
