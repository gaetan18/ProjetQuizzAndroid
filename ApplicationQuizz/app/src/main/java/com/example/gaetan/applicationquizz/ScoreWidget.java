package com.example.gaetan.applicationquizz;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.example.gaetan.applicationquizz.SQLite.DataBaseManager;

/**
 * Implementation of App Widget functionality.
 */
public class ScoreWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        DataBaseManager dbm = new DataBaseManager(context);

        int scoreMax = dbm.getScoreMax();
        //scoreMax = dbm.getScoreMax().getScore();

        CharSequence widgetText = "QUI Quizz \nVenez battre le reccord ! \nMeilleur Score : "+scoreMax+" bonnes réponses à la suite !";
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.score_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);


    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

