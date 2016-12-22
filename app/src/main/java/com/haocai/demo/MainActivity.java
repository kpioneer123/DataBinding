package com.haocai.demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.haocai.demo.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    private Employee employee = new Employee(1001, "xionghu", 25);
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setEmployee(employee);
        binding.setPresenter(new Presenter());
       // binding.setVariable(BR.employee,employee);
//        binding.tv1.setText(employee.getName());
//        binding.tv2.setText(employee.getAge() + "岁");

    }

//
//    TextWatcher watcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//
//        }
//    }
    public class Presenter {
        public void onTextChanged(CharSequence s, int start, int before, int count ){

            if(s.length()==0)
            {
                employee.setAge(0);
            }else {
                employee.setAge(Integer.valueOf(s.toString()));
            }

            binding.setEmployee(employee);
        }
        public  void  onClick(View view)
        {
            Toast.makeText(MainActivity.this,"点到了",Toast.LENGTH_SHORT).show();
        }
        public  void onClickListenerBinding(Employee employee){
            Toast.makeText(MainActivity.this,employee.getName(),Toast.LENGTH_SHORT).show();
        }
    }



}
