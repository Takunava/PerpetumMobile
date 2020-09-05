package com.example.perpetummobile.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.perpetummobile.R;

import java.util.concurrent.atomic.AtomicBoolean;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        AtomicBoolean flag = new AtomicBoolean(false);
        final Button button = root.findViewById(R.id.button);
        button.setText("I'm not a gay");
        button.setOnClickListener(event -> {
            if(flag.get()){
                textView.setText("lesbian, transgender ?!?");
                button.setText(".....");
                flag.set(false);

            } else {
                textView.setText("Why?!?!");
                button.setText("because am not a gay");
                flag.set(true);
            }
        });
        return root;
    }
}