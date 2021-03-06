package com.walle.gankio.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.walle.gankio.data.local.entity.Collect;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "COLLECT".
*/
public class CollectDao extends AbstractDao<Collect, String> {

    public static final String TABLENAME = "COLLECT";

    /**
     * Properties of entity Collect.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", false, "ID");
        public final static Property Desc = new Property(1, String.class, "desc", false, "DESC");
        public final static Property Url = new Property(2, String.class, "url", true, "URL");
        public final static Property Collect_date = new Property(3, long.class, "collect_date", false, "COLLECT_DATE");
    }


    public CollectDao(DaoConfig config) {
        super(config);
    }
    
    public CollectDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"COLLECT\" (" + //
                "\"ID\" INTEGER NOT NULL ," + // 0: id
                "\"DESC\" TEXT," + // 1: desc
                "\"URL\" TEXT PRIMARY KEY NOT NULL ," + // 2: url
                "\"COLLECT_DATE\" INTEGER NOT NULL );"); // 3: collect_date
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COLLECT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Collect entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(2, desc);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(3, url);
        }
        stmt.bindLong(4, entity.getCollect_date());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Collect entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(2, desc);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(3, url);
        }
        stmt.bindLong(4, entity.getCollect_date());
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
    }    

    @Override
    public Collect readEntity(Cursor cursor, int offset) {
        Collect entity = new Collect( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // desc
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // url
            cursor.getLong(offset + 3) // collect_date
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Collect entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setDesc(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUrl(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCollect_date(cursor.getLong(offset + 3));
     }
    
    @Override
    protected final String updateKeyAfterInsert(Collect entity, long rowId) {
        return entity.getUrl();
    }
    
    @Override
    public String getKey(Collect entity) {
        if(entity != null) {
            return entity.getUrl();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Collect entity) {
        return entity.getUrl() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
