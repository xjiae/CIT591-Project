package com.github.premnirmal.ticker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.github.premnirmal.ticker.components.Injector
import com.github.premnirmal.ticker.network.SimpleSubscriber
import com.github.premnirmal.ticker.model.IStocksProvider
import javax.inject.Inject

/**
 * Created by premnirmal on 2/27/16.
 */
class UpdateReceiver : BroadcastReceiver() {

  @Inject internal lateinit var stocksProvider: IStocksProvider

  override fun onReceive(context: Context, intent: Intent) {
    Injector.appComponent.inject(this)
    stocksProvider.fetch().subscribe(SimpleSubscriber())
  }
}