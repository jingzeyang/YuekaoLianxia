package com.baway.jingzeyang;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.baway.jingzeyang.utils.OkHttputils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 荆泽阳 on 2017/3/8.
 * .::::.
 * .::::::::.
 * :::::::::::  Goddess bless, never bug
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 */

public class HomeActivoty extends AppCompatActivity {
    int i = 0;
    int a = 2;
    private XrecyclerViewAdapter xrecyclerViewAdapter;
    private List<Bean.ResultBean.RowsBean.InfoBean> lista;
    private XRecyclerView xRecyclerView;
    private String path = "http://api.fang.anjuke.com/m/android/1.3/shouye/recInfosV3/?city_id=14&lat=40.04652&lng=116.306033&api_key=androidkey&sig=9317e9634b5fbc16078ab07abb6661c5&macid=45cd2478331b184ff0e15f29aaa89e3e&app=a-ajk&_pid=11738&o=PE-TL10-user+4.4.2+HuaweiPE-TL10+CHNC00B260+ota-rel-keys%2Crelease-keys&from=mobile&m=Android-PE-TL10&cv=9.5.1&cid=14&i=864601026706713&v=4.4.2&pm=b61&uuid=1848c59c-185d-48d9-b0e9-782016041109&_chat_id=0&qtime=20160411091603";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeitem);
        xRecyclerView = (XRecyclerView) findViewById(R.id.XrecyclerView);
        xRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        lista = new ArrayList<Bean.ResultBean.RowsBean.InfoBean>();
        xRecyclerView.setLoadingMoreEnabled(true);
        getDate(1);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                i++;
                path = "http://api.fang.anjuke.com/m/android/1.3/shouye/recInfosV3/?city_id=14&lat=40.04652&lng=116.306033&api_key=androidkey&sig=9317e9634b5fbc16078ab07abb6661c5&macid=45cd2478331b184ff0e15f29aaa89e3e&app=a-ajk&_pid=11738&o=PE-TL10-user+4.4.2+HuaweiPE-TL10+CHNC00B260+ota-rel-keys%2Crelease-keys&from=mobile&m=Android-PE-TL10&cv=9.5.1&cid=14&i=864601026706713&v=4.4.2&pm=b61&uuid=1848c59c-185d-48d9-b0e9-782016041109&_chat_id=0&qtime=20170211091603";
                getDate(2);
            }

            @Override
            public void onLoadMore() {
                a++;
                path = "http://api.fang.anjuke.com/m/android/1.3/shouye/recInfosV3/?city_id=14&lat=40.04652&lng=116.306033&api_key=androidkey&sig=9317e9634b5fbc16078ab07abb6661c5&macid=45cd2478331b184ff0e15f29aaa89e3e&app=a-ajk&_pid=11738&o=PE-TL10-user+4.4.2+HuaweiPE-TL10+CHNC00B260+ota-rel-keys%2Crelease-keys&from=mobile&m=Android-PE-TL10&cv=9.5.1&cid=14&i=864601026706713&v=4.4.2&pm=b61&uuid=1848c59c-185d-48d9-b0e9-782016041109&_chat_id=0&qtime=20160611091603";
                getDate(3);
            }
        });


    }

    private void getDate(final int ll) {

        OkHttputils httputils = OkHttputils.getHttpUtils();
        httputils.loadDataFromNet(path, Bean.class, new OkHttputils.CallBackListener<Bean>() {


            @Override
            public void onSuccess(Bean result) {

                List<Bean.ResultBean.RowsBean> rows = result.getResult().getRows();


                if (ll == 1) {
                    for (Bean.ResultBean.RowsBean aa : rows) {
                        lista.add(aa.getInfo());
                    }
                    Log.i("TAG", lista.toString());
                    xrecyclerViewAdapter = new XrecyclerViewAdapter(lista, HomeActivoty.this);
                    xRecyclerView.setAdapter(xrecyclerViewAdapter);


                }
                if (ll == 2) {
                    lista.clear();
                    for (Bean.ResultBean.RowsBean aa : rows) {

                        lista.add(aa.getInfo());
                    }
                    Log.i("TAG", lista.toString());

                    xRecyclerView.refreshComplete();
                    xrecyclerViewAdapter.notifyDataSetChanged();


                }
                if (ll == 3) {

                    for (Bean.ResultBean.RowsBean aa : rows) {
                        lista.add(aa.getInfo());
                    }
                    Log.i("TAG", lista.toString());

                    xRecyclerView.loadMoreComplete();
                    xrecyclerViewAdapter.notifyDataSetChanged();


                }


            }

            @Override
            public void onFail() {

            }
        });


    }


}
