package com.example.ji.smartclothes.utils;

import android.content.Context;

import com.aidebar.greendaotest.gen.DaoManager;
import com.aidebar.greendaotest.gen.WeatherDao;
import com.example.ji.smartclothes.bean.Weather;

import java.util.List;

public class DBWeatherUtils {

    private WeatherDao dbUserInvestmentDao;
    private static DBWeatherUtils dbUserInvestmentUtils = null;

    public DBWeatherUtils(Context context) {
        dbUserInvestmentDao = DaoManager.getInstance(context).getNewSession().getWeatherDao();
    }

    public static DBWeatherUtils getInstance() {
        return dbUserInvestmentUtils;
    }

    public static void Init(Context context) {
        if (dbUserInvestmentUtils == null) {
            dbUserInvestmentUtils = new DBWeatherUtils(context);
        }
    }

    /**
     * 完成对数据库中插入一条数据操作
     *
     * @param
     * @return
     */
    public void insertOneData(Weather dbExameBean) {
        dbUserInvestmentDao.insertOrReplace(dbExameBean);
    }

    /**
     * 完成对数据库中插入多条数据操作
     *
     * @param dbUserInvestmentList
     * @return
     */
    public boolean insertManyData(List<Weather> dbUserInvestmentList) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.insertOrReplaceInTx(dbUserInvestmentList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中删除一条数据操作
     *
     * @param dbUserInvestment
     * @return
     */
    public boolean deleteOneData(Weather dbUserInvestment) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.delete(dbUserInvestment);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中删除一条数据 ByKey操作
     *
     * @return
     */
    public boolean deleteOneDataByKey(long id) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.deleteByKey(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中批量删除数据操作
     *
     * @return
     */
    public boolean deleteManData(List<Weather> dbUserInvestmentList) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.deleteInTx(dbUserInvestmentList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中批量删除所有数据
     *
     * @return
     */
    public boolean deleteAllData() {
        boolean flag = false;
        try {
            dbUserInvestmentDao.deleteAll();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库更新数据操作
     *
     * @return
     */
    public boolean updateData(Weather dbUserInvestment) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.update(dbUserInvestment);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库批量更新数据操作
     *
     * @return
     */
    public boolean updateManData(List<Weather> dbUserInvestmentList) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.updateInTx(dbUserInvestmentList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库查询数据操作
     *
     * @return
     */
    public Weather queryOneData(long id) {
        return dbUserInvestmentDao.load(id);
    }

    /**
     * 完成对数据库查询所有数据操作
     *
     * @return
     */
    public List<Weather> queryAllData() {
        return dbUserInvestmentDao.loadAll();
    }
}
