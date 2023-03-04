package com.example.sqldelightproject.di

import android.app.Application
import com.example.sqldelightproject.PersonDatabse
import com.example.sqldelightproject.data.PersonDataSource
import com.example.sqldelightproject.data.PersonDataSourceImpl
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DB_NAME = "person.db"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideSqlDriver(app: Application): SqlDriver = AndroidSqliteDriver(
        schema = PersonDatabse.Schema,
        context = app,
        name = DB_NAME
    )

    @Provides
    fun providesPersonDataSource(driver: AndroidSqliteDriver): PersonDataSource  {
        return PersonDataSourceImpl(
            db = PersonDatabse(driver)
        )
    }

}