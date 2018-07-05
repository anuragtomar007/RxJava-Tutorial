package com.example.anurag.rxjavatutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private Observable<String> observable;
    private Observer<String> observer;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscribeNow();
            }
        });

        observable = Observable.just("First RxJava App Done");

        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                textView.setText(s);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "Process Completed", Toast.LENGTH_SHORT).show();
            }
        };

    }

    private void subscribeNow() {
        observable.subscribe(observer);
    }
}
