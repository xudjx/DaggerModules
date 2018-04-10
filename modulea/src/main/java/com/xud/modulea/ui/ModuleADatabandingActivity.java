package com.xud.modulea.ui;

import android.databinding.ObservableField;
import android.os.Bundle;

import com.google.gson.Gson;
import com.xud.base.Constants;
import com.xud.base.core.BaseDataBindingActivity;
import com.xud.base.di.BaseViewModule;
import com.xud.base.modulekit.BusinessAModuleKit;
import com.xud.base.net.ApiError;
import com.xud.base.net.HttpResponseObserver;
import com.xud.modulea.R;
import com.xud.modulea.databinding.ModuleAFragmentDatabandBinding;
import com.xud.modulea.di.BusinessAAppComponent;
import com.xud.modulea.di.DJDataBandingComponent;
import com.xud.modulea.di.DaggerDJDataBandingComponent;
import com.xud.modulea.entity.CityWeatherDTO;
import com.xud.modulea.entity.RestResultDTO;
import com.xud.modulea.net.BusinessAApi;

import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xud on 2018/4/10.
 */

public class ModuleADatabandingActivity extends BaseDataBindingActivity<ModuleAFragmentDatabandBinding> {

    private DJDataBandingComponent mDJDataBandingComponent;

    public DJDataBandingComponent dbComponent() {
        if(mDJDataBandingComponent == null) {
            mDJDataBandingComponent = DaggerDJDataBandingComponent.builder()
                    .businessAAppComponent((BusinessAAppComponent) BusinessAModuleKit.getInstance().getComponent())
                    .baseViewModule(new BaseViewModule(this))
                    .build();
        }
        return mDJDataBandingComponent;
    }

    @Inject
    BusinessAApi businessAApi;

    ViewModel viewModel;

    @Override
    protected void onCreated(Bundle savedInstanceState) {
        super.onCreated(savedInstanceState);
        dbComponent().inject(this);
        viewModel = new ViewModel();
        mBinding.setViewModel(viewModel);
        initData();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.module_a_fragment_databand;
    }

    private void initData() {
        businessAApi.getCityWeather(Constants.MOB_APP_KEY, "上海", "上海")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpResponseObserver<RestResultDTO<CityWeatherDTO>>() {
                    @Override
                    public void onNext(RestResultDTO<CityWeatherDTO> cityWeatherDTORestResultDTO) {
                        List<CityWeatherDTO> cityWeatherDTOS = cityWeatherDTORestResultDTO.getResult();
                        viewModel.detail.set(new Gson().toJson(cityWeatherDTOS));
                    }

                    @Override
                    protected boolean onError(ApiError error) {
                        return super.onError(error);
                    }
                });
    }

    public class ViewModel {
        public ObservableField<String> detail = new ObservableField<>();
    }
}
