package com.example.andriodhw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.andriodhw.adapters.MovieAdapter;
import com.example.andriodhw.databinding.FragmentRecyclerViewBinding;
import com.example.andriodhw.models.MovieModel;

import java.util.List;

public class RecyclerViewFragment extends Fragment {

    private FragmentRecyclerViewBinding binding;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<MovieModel> movies = getMovieList();

        MovieAdapter adapter = new MovieAdapter(movies);
        binding.recyclerView.setAdapter(adapter);
    }

    private List<MovieModel> getMovieList() {
        return List.of(
                new MovieModel(4.8, "Premium", "Inception", 2010, 148, "NC-15", "Sci-Fi", R.drawable.mv_interception),
                new MovieModel(0, "Free", "The Dark Knight", 2008, 152, "NC-15", "Action", R.drawable.mv_thedarkknight),
                new MovieModel(1.5, "Premium", "Pulp Fiction", 1994, 154, "R-18", "Crime", R.drawable.mv_pulpfiction),
                new MovieModel(4.1, "Free", "Interstellar", 2014, 169, "NC-15", "Sci-Fi", R.drawable.mv_interstellar),
                new MovieModel(0, "Premium", "Spider-Man: Into the Spider-Verse", 2018, 117, "G", "Animation", R.drawable.mv_spiderman),
                new MovieModel(0.8, "Free", "Parasite", 2019, 132, "R-18", "Thriller", R.drawable.mv_parasite),
                new MovieModel(5.0, "Premium", "The Lord of the Rings: The Fellowship of the Ring", 2001, 178, "NC-15", "Fantasy", R.drawable.mv_lordofthering),
                new MovieModel(3.7, "Free", "Spirited Away", 2001, 125, "G", "Animation", R.drawable.mv_spiritaway),
                new MovieModel(4.3, "Premium", "The Matrix", 1999, 136, "NC-15", "Sci-Fi", R.drawable.mv_matrix),
                new MovieModel(2.1, "Free", "Whiplash", 2014, 106, "NC-15", "Drama", R.drawable.mv_naja),
                new MovieModel(3.9, "Premium", "Iron Man", 2008, 126, "NC-15", "Action", R.drawable.mv_ironman),
                new MovieModel(4.6, "Free", "Coco", 2017, 105, "G", "Animation", R.drawable.mv_coco),
                new MovieModel(1.2, "Premium", "Blade Runner 2049", 2017, 164, "R-18", "Sci-Fi", R.drawable.mv_bladerunner),
                new MovieModel(3.4, "Free", "Grand Budapest Hotel", 2014, 99, "NC-15", "Comedy", R.drawable.mv_thegrandbudapesthotel),
                new MovieModel(4.9, "Premium", "The Silence of the Lambs", 1991, 118, "R-18", "Horror", R.drawable.mv_thesilenceofthelamp),
                new MovieModel(2.5, "Free", "Get Out", 2017, 104, "R-18", "Horror", R.drawable.mv_getout),
                new MovieModel(3.8, "Premium", "Knives Out", 2019, 130, "NC-15", "Mystery", R.drawable.mv_kniveout),
                new MovieModel(4.4, "Free", "Toy Story", 1995, 81, "G", "Animation", R.drawable.mv_toystory),
                new MovieModel(1.9, "Premium", "Alien", 1979, 117, "R-18", "Sci-Fi", R.drawable.mv_alien),
                new MovieModel(3.0, "Free", "Avatar", 2009, 162, "NC-15", "Action", R.drawable.mv_avatar)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}