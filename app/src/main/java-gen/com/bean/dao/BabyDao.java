package com.bean.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.bean.entity.Baby;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BABY".
*/
public class BabyDao extends AbstractDao<Baby, Long> {

    public static final String TABLENAME = "BABY";

    /**
     * Properties of entity Baby.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Bid = new Property(1, String.class, "bid", false, "BID");
        public final static Property Fid = new Property(2, String.class, "fid", false, "FID");
        public final static Property Name = new Property(3, String.class, "name", false, "NAME");
        public final static Property Age = new Property(4, String.class, "age", false, "AGE");
        public final static Property Sex = new Property(5, String.class, "sex", false, "SEX");
        public final static Property Weight = new Property(6, String.class, "weight", false, "WEIGHT");
        public final static Property Hight = new Property(7, String.class, "hight", false, "HIGHT");
        public final static Property DeviceName = new Property(8, String.class, "deviceName", false, "DEVICE_NAME");
        public final static Property Img = new Property(9, String.class, "img", false, "IMG");
        public final static Property Isconnect = new Property(10, Boolean.class, "isconnect", false, "ISCONNECT");
    };


    public BabyDao(DaoConfig config) {
        super(config);
    }
    
    public BabyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BABY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"BID\" TEXT," + // 1: bid
                "\"FID\" TEXT," + // 2: fid
                "\"NAME\" TEXT," + // 3: name
                "\"AGE\" TEXT," + // 4: age
                "\"SEX\" TEXT," + // 5: sex
                "\"WEIGHT\" TEXT," + // 6: weight
                "\"HIGHT\" TEXT," + // 7: hight
                "\"DEVICE_NAME\" TEXT," + // 8: deviceName
                "\"IMG\" TEXT," + // 9: img
                "\"ISCONNECT\" INTEGER);"); // 10: isconnect
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BABY\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Baby entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String bid = entity.getBid();
        if (bid != null) {
            stmt.bindString(2, bid);
        }
 
        String fid = entity.getFid();
        if (fid != null) {
            stmt.bindString(3, fid);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(5, age);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(6, sex);
        }
 
        String weight = entity.getWeight();
        if (weight != null) {
            stmt.bindString(7, weight);
        }
 
        String hight = entity.getHight();
        if (hight != null) {
            stmt.bindString(8, hight);
        }
 
        String deviceName = entity.getDeviceName();
        if (deviceName != null) {
            stmt.bindString(9, deviceName);
        }
 
        String img = entity.getImg();
        if (img != null) {
            stmt.bindString(10, img);
        }
 
        Boolean isconnect = entity.getIsconnect();
        if (isconnect != null) {
            stmt.bindLong(11, isconnect ? 1L: 0L);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Baby readEntity(Cursor cursor, int offset) {
        Baby entity = new Baby( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // bid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // fid
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // age
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // sex
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // weight
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // hight
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // deviceName
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // img
            cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10) != 0 // isconnect
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Baby entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFid(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAge(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSex(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setWeight(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setHight(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDeviceName(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setImg(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setIsconnect(cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Baby entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Baby entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}