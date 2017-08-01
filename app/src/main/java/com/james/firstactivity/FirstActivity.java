package com.james.firstactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载activity的一个布局
        setContentView(R.layout.first_layout);
        /*Log.d("FirstActivity",this.toString());*/
        //Log.d("FirstActivity","task id is:"+getTaskId());
        /*Toast是一种提醒，现在设定一个toast的触发点*/
        Button button_1=(Button)findViewById(R.id.button_1);//获取一个view
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Toast.makeText(FirstActivity.this,"You clicked button 1",Toast.LENGTH_SHORT).show();*/

               //销毁一个活动
               /*finish();*/

               /*通过intent启动另外一个服务
               * 传入firstActivity上下文
               * 传入secondActivity.class作为目标活动
               * 通过startActivity跳入另外一个活动*/
               /* Intent intent=new Intent(FirstActivity.this,SecondActivity.class);//创建intent对象
                startActivity(intent);*/

               /*隐式启动一个activity*/
               /*Intent intent=new Intent("com.james.firstactivity.ACTION_START");
                startActivity(intent);*/

               /*//打开浏览器
               Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);*/

               //打开拨号界面
                /*Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/

                //将数据传入到下一个activity中
                /*String data="hello world";
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);*/

                //返回数据给上一个Intent
                /*Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                *//*
                * param:requseCode:确定请求哪一个activity*//*
                startActivityForResult(intent,1);*/

                /*activity启动模式：
                * standard:每一次启动该activity都会新建一个实例，新的实例进入返回栈栈顶
                * singleTop: 如果返回栈的栈顶已经是该activity,则不再创建该活动的新实例
                *直接返回要位于栈顶的实例，反之，还是会创建新的实例
                * singleTask:从返回栈中查找该activity的实例，找到后该实例之上的activity全部出栈
                * */
                Intent intent=new Intent(FirstActivity.this,ThirdActivity.class);
                startActivity(intent);



            }
        });

    }

    //在活动中添加菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);//获取menuinflater对象，调用inflate方法给当前活动创建菜单
        return true;
    }

    @Override
    //定义菜单响应事件
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked add_item",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.remove_item:
                Toast.makeText(this,"You clicked remove_item",Toast.LENGTH_SHORT).show();
                break;

        default:
        }
        return true;

    }

    @Override
    //获取activity返回的数据
    /*
    * param requestCode 用于确定来自哪一个activity返回的结果
    * */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String returnData=data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnData);

                }
                break;
                default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }
}
