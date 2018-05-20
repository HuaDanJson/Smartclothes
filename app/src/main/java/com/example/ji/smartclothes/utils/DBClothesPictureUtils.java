package com.example.ji.smartclothes.utils;

import android.content.Context;

import com.aidebar.greendaotest.gen.ClothesPictureDao;
import com.aidebar.greendaotest.gen.DaoManager;
import com.example.ji.smartclothes.bean.ClothesPicture;

import java.util.List;

public class DBClothesPictureUtils {

    private ClothesPictureDao dbUserInvestmentDao;
    private static DBClothesPictureUtils dbUserInvestmentUtils = null;

    public DBClothesPictureUtils(Context context) {
        dbUserInvestmentDao = DaoManager.getInstance(context).getNewSession().getClothesPictureDao();
    }

    public static DBClothesPictureUtils getInstance() {
        return dbUserInvestmentUtils;
    }

    public static void Init(Context context) {
        if (dbUserInvestmentUtils == null) {
            dbUserInvestmentUtils = new DBClothesPictureUtils(context);
        }
    }

    /**
     * 完成对数据库中插入一条数据操作
     *
     * @param
     * @return
     */
    public void insertOneData(ClothesPicture dbExameBean) {
        dbUserInvestmentDao.insertOrReplace(dbExameBean);
    }

    /**
     * 完成对数据库中插入多条数据操作
     *
     * @param dbUserInvestmentList
     * @return
     */
    public boolean insertManyData(List<ClothesPicture> dbUserInvestmentList) {
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
    public boolean deleteOneData(ClothesPicture dbUserInvestment) {
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
    public boolean deleteManData(List<ClothesPicture> dbUserInvestmentList) {
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
    public boolean updateData(ClothesPicture dbUserInvestment) {
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
    public boolean updateManData(List<ClothesPicture> dbUserInvestmentList) {
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
    public ClothesPicture queryOneData(long id) {
        return dbUserInvestmentDao.load(id);
    }

    /**
     * 完成对数据库查询所有数据操作
     *
     * @return
     */
    public List<ClothesPicture> queryAllData() {
        return dbUserInvestmentDao.loadAll();
    }

    /**
     * 完成对数据库条件查询数据操作 senderId
     *
     * @return
     */
    public List<ClothesPicture> queryDataDependIsSelected(boolean isSeleced) {
        return dbUserInvestmentDao.queryBuilder().where(ClothesPictureDao.Properties.IsSelected.eq(isSeleced)).build().list();
    }
}
