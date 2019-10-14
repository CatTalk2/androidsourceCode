package com.debugcat.eventbusdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
//
//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_event)
    TextView tvEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tvEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBoss.getDefault().post(new MessageEvent(1, "哈哈哈"));
            }
        });

        EventBoss.getDefault().register(this);
    }


    /**
     * 思考：如何巧妙利用注解
     *
     * 附加参数ThreadMode：用于区分此方法在哪个线程被调用
     *
     * 1. Posting: 默认，哪个线程post，哪个线程调，
     *
     * 2. Main: 不管从哪post，都在Main调用
     *
     * 3. Main-orderd: Main线程同步调用： 优先级插到前面？
     *
     * 4. Async: 不管哪个post，都是在另一个thread中调用
     *
     * 5. background: 如果post是非主线程，就直接在post线程，否则在background
     *
     *
     * 因此必然有个用于处理有个集合管理当前  subscriber<==>thread之间关系的地方
     *
     *
     * {@link org.greenrobot.eventbus.Subscription }: 描述register & subscribe method
     *
     * {@link org.greenrobot.eventbus.SubscriberMethodFinder } 主要是用来从一个list中查找符合条件的
     */
    @Subcriber
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, event.data, Toast.LENGTH_LONG).show();
    }

    public static class MessageEvent {
        public int message;
        public String data;

        public MessageEvent(int message, String data) {
            this.message = message;
            this.data = data;
        }
    }
}
