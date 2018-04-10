package com.xud.modulea.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xud.base.Constants;
import com.xud.base.net.ApiError;
import com.xud.base.net.HttpResponseObserver;
import com.xud.componentlib.router.ui.RouterManager;
import com.xud.modulea.R;
import com.xud.modulea.R2;
import com.xud.modulea.entity.CityWeatherDTO;
import com.xud.modulea.entity.RestResultDTO;
import com.xud.modulea.net.BusinessAApi;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xud on 2018/3/25.
 */

public class BusinessAMainFragment extends BaseBusinessAFragment {

    @Inject
    BusinessAApi businessAApi;

    @BindView(R2.id.province_edit)
    EditText provinceEdit;
    @BindView(R2.id.city_edit)
    EditText cityEdit;
    @BindView(R2.id.search)
    Button searchBtn;
    @BindView(R2.id.detail_view)
    TextView detailView;
    @BindView(R2.id.jump)
    Button jumpBtn;
    @BindView(R2.id.innerGoto)
    Button innerGoto;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_a_fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        setHomeAsUpIndicator(false);
        setTitle("天气模块");
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String province = provinceEdit.getText().toString().trim();
                String city = cityEdit.getText().toString().trim();
                businessAApi.getCityWeather(Constants.MOB_APP_KEY, province, city)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new HttpResponseObserver<RestResultDTO<CityWeatherDTO>>() {
                            @Override
                            public void onNext(RestResultDTO<CityWeatherDTO> cityWeatherDTORestResultDTO) {
                                List<CityWeatherDTO> cityWeatherDTOS = cityWeatherDTORestResultDTO.getResult();
                                detailView.setText(new Gson().toJson(cityWeatherDTOS));
                            }

                            @Override
                            protected boolean onError(ApiError error) {
                                return super.onError(error);
                            }
                        });
            }
        });
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouterManager.newPage(RouterManager.URL_MAIN_BUSINESS_B);
            }
        });
        innerGoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ModuleADatabandingActivity.class));
            }
        });
    }
}
