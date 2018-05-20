package com.aidebar.greendaotest.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.ji.smartclothes.bean.Weather;
import com.example.ji.smartclothes.bean.ClothesPicture;

import com.aidebar.greendaotest.gen.WeatherDao;
import com.aidebar.greendaotest.gen.ClothesPictureDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig weatherDaoConfig;
    private final DaoConfig clothesPictureDaoConfig;

    private final WeatherDao weatherDao;
    private final ClothesPictureDao clothesPictureDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        weatherDaoConfig = daoConfigMap.get(WeatherDao.class).clone();
        weatherDaoConfig.initIdentityScope(type);

        clothesPictureDaoConfig = daoConfigMap.get(ClothesPictureDao.class).clone();
        clothesPictureDaoConfig.initIdentityScope(type);

        weatherDao = new WeatherDao(weatherDaoConfig, this);
        clothesPictureDao = new ClothesPictureDao(clothesPictureDaoConfig, this);

        registerDao(Weather.class, weatherDao);
        registerDao(ClothesPicture.class, clothesPictureDao);
    }
    
    public void clear() {
        weatherDaoConfig.clearIdentityScope();
        clothesPictureDaoConfig.clearIdentityScope();
    }

    public WeatherDao getWeatherDao() {
        return weatherDao;
    }

    public ClothesPictureDao getClothesPictureDao() {
        return clothesPictureDao;
    }

}
