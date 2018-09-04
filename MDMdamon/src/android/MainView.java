package android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Date;
import com.idata.mdmdamon.R;
import oscommodule.Gather;
import oscommodule.OsModule;

public class MainView extends Activity{

	private OsModule osModule;
	private TextView _tv;
	private static String tag="MainView";
	private ScrollView scrollView1;
	
	private PowerManager pManager;
	private WakeLock mWakeLock = null;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		this.registerBroadcast();
		
		pManager = ((PowerManager) getSystemService(POWER_SERVICE));   
        mWakeLock = pManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK                                      //允许手机灭屏，但是CPU不休眠。 
                | PowerManager.ON_AFTER_RELEASE, tag);   
        mWakeLock.acquire();  

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainview);

		osModule = new OsModule(getApplicationContext(), handler);
		osModule.OpenMonitor();

		Button _bt20=(Button) findViewById(R.id.button20);
		_tv = (TextView) findViewById(R.id._tv);
		_tv.setMovementMethod(ScrollingMovementMethod.getInstance());
		Button _bt1 = (Button) findViewById(R.id.button1);
		Button _bt2 = (Button) findViewById(R.id.button2);
		Button _bt3 = (Button) findViewById(R.id.button3);
		Button _bt4 = (Button) findViewById(R.id.button4);
		Button _bt5 = (Button) findViewById(R.id.button5);
		Button _bt6 = (Button) findViewById(R.id.button6);
		Button _bt7 = (Button) findViewById(R.id.button7);
		Button _bt8 = (Button) findViewById(R.id.button8);
		Button _bt9 = (Button) findViewById(R.id.button9);
		Button _bt10 = (Button) findViewById(R.id.button10);
		//Button _bt11 = (Button) findViewById(R.id.button11);
		Button _bt12 = (Button) findViewById(R.id.button12);
		Button _bt13 = (Button) findViewById(R.id.button13);
		//Button _bt14 = (Button) findViewById(R.id.button14);
		Button _bt15 = (Button) findViewById(R.id.button15);
		Button _bt16 = (Button) findViewById(R.id.button16);
		Button _bt17 = (Button) findViewById(R.id.button17);
		Button _bt18 = (Button) findViewById(R.id.button18);
		Button _bt19 = (Button) findViewById(R.id.button19);
		Button btn_sethome = (Button) findViewById(R.id.btn_sethome);
		Button btn_gethome=(Button) findViewById(R.id.btn_gethome);
		Button btn_setSound=(Button) findViewById(R.id.btn_setSound);
		Button btn_getSound=(Button) findViewById(R.id.btn_getSound);
		//Button btn_set_keyboardwakeUp=(Button)findViewById(R.id.btn_set_keyboardwakeUp);
		//Button btn_get_keyboardwakeUp=(Button)findViewById(R.id.btn_get_keyboardwakeUp);
		Button btn_set_unapkinstallui=(Button) findViewById(R.id.btn_set_unapkinstallui);
		Button btn_get_unapkinstallui=(Button) findViewById(R.id.btn_get_unapkinstallui);
		Button btn_get_romuid=(Button) findViewById(R.id.btn_get_romuid);
		Button btn_get_romver=(Button) findViewById(R.id.btn_get_romver);
		Button btn_set_gps=(Button)findViewById(R.id.btn_set_gps);
		Button btn_get_gps=(Button)findViewById(R.id.btn_get_gps);
		Button btn_set_wifi=(Button)findViewById(R.id.btn_set_wifi);
		Button btn_get_wifi=(Button)findViewById(R.id.btn_get_wifi);
		Button btn_set_bluetooth=(Button)findViewById(R.id.btn_set_bluetooth);
		Button btn_get_bluetooth=(Button)findViewById(R.id.btn_get_bluetooth);
		//Button btn_set_mobiledata=(Button)findViewById(R.id.btn_set_mobiledata);
		//Button btn_get_mobiledata=(Button)findViewById(R.id.btn_get_mobiledata);
		//Button btn_set_earphonevol=(Button)findViewById(R.id.btn_set_earphonevol);
		//Button btn_get_earphonevol=(Button)findViewById(R.id.btn_get_earphonevol);
		//Button btn_set_speakervol=(Button)findViewById(R.id.btn_set_speakervol);
		//Button btn_get_speakervol=(Button)findViewById(R.id.btn_get_speakervol);
		//Button btn_set_hummervol=(Button)findViewById(R.id.btn_set_hummervol);
		//Button btn_get_hummervol=(Button)findViewById(R.id.btn_get_hummervol);
		//Button btn_set_camear=(Button)findViewById(R.id.btn_set_camear);
		//Button btn_set_phone=(Button)findViewById(R.id.btn_set_phone);
		//Button btn_set_sms=(Button)findViewById(R.id.btn_set_sms);
		//Button btn_set_browser=(Button)findViewById(R.id.btn_set_browser);
		Button btn_set_installapkblacklist=(Button)findViewById(R.id.btn_set_installapkblacklist);
		Button btn_get_installapkblacklist=(Button)findViewById(R.id.btn_get_installapkblacklist);
		Button btn_installapkblacklist=(Button)findViewById(R.id.btn_installapkblacklist);
		Button make_clear = (Button)findViewById(R.id.make_clear);
		Button btn_packagename = (Button)findViewById(R.id.btn_packagename);
		Button btn_uninstallapkbyname=(Button) findViewById(R.id.btn_uninstallapkbyname);
		Button btn_set_system_reset=(Button) findViewById(R.id.btn_set_system_reset);
		Button btn_get_system_reset=(Button) findViewById(R.id.btn_get_system_reset);
		Button btn_set_power_optimization=(Button) findViewById(R.id.btn_set_power_optimization);
		Button btn_get_power_optimization=(Button) findViewById(R.id.btn_get_power_optimization);
		
		Button btn_set_app_accessibility=(Button) findViewById(R.id.btn_set_app_accessibility);
		Button btn_get_app_accessibility=(Button) findViewById(R.id.btn_get_app_accessibility);
		
		Button btn_set_resident_backstage=(Button) findViewById(R.id.btn_set_resident_backstage);
		Button btn_get_resident_backstage=(Button) findViewById(R.id.btn_get_resident_backstage);
		
		ClickListener clicklistener = new ClickListener();

		
		btn_set_system_reset.setOnClickListener(clicklistener);
		btn_get_system_reset.setOnClickListener(clicklistener);
		
		btn_set_power_optimization.setOnClickListener(clicklistener);
		btn_get_power_optimization.setOnClickListener(clicklistener);
		
		btn_set_app_accessibility.setOnClickListener(clicklistener);
		btn_get_app_accessibility.setOnClickListener(clicklistener);
		
		btn_set_resident_backstage.setOnClickListener(clicklistener);
		btn_get_resident_backstage.setOnClickListener(clicklistener);
		
		_bt1.setOnClickListener(clicklistener);
		_bt2.setOnClickListener(clicklistener);
		_bt3.setOnClickListener(clicklistener);
		_bt4.setOnClickListener(clicklistener);
		_bt5.setOnClickListener(clicklistener);
		_bt6.setOnClickListener(clicklistener);
		_bt7.setOnClickListener(clicklistener);
		_bt8.setOnClickListener(clicklistener);
		_bt9.setOnClickListener(clicklistener);
		_bt10.setOnClickListener(clicklistener);
		//_bt11.setOnClickListener(clicklistener);
		_bt12.setOnClickListener(clicklistener);
		_bt13.setOnClickListener(clicklistener);
		//_bt14.setOnClickListener(clicklistener);
		_bt15.setOnClickListener(clicklistener);
		_bt16.setOnClickListener(clicklistener);
		_bt17.setOnClickListener(clicklistener);
		_bt18.setOnClickListener(clicklistener);
		_bt19.setOnClickListener(clicklistener);
		_bt20.setOnClickListener(clicklistener);
		make_clear.setOnClickListener(clicklistener);
		btn_sethome.setOnClickListener(clicklistener);
		btn_gethome.setOnClickListener(clicklistener);
		btn_setSound.setOnClickListener(clicklistener);
		btn_getSound.setOnClickListener(clicklistener);
		//btn_set_keyboardwakeUp.setOnClickListener(clicklistener);
		//btn_get_keyboardwakeUp.setOnClickListener(clicklistener);
		btn_set_unapkinstallui.setOnClickListener(clicklistener);
		btn_get_unapkinstallui.setOnClickListener(clicklistener);
		btn_get_romuid.setOnClickListener(clicklistener);
		btn_get_romver.setOnClickListener(clicklistener);
		btn_set_gps.setOnClickListener(clicklistener);
		btn_get_gps.setOnClickListener(clicklistener);
		btn_set_wifi.setOnClickListener(clicklistener);
		btn_get_wifi.setOnClickListener(clicklistener);
		btn_set_bluetooth.setOnClickListener(clicklistener);
		btn_get_bluetooth.setOnClickListener(clicklistener);
		//btn_set_mobiledata.setOnClickListener(clicklistener);
		//btn_get_mobiledata.setOnClickListener(clicklistener);
		//btn_set_earphonevol.setOnClickListener(clicklistener);
		//btn_get_earphonevol.setOnClickListener(clicklistener);
		//btn_set_speakervol.setOnClickListener(clicklistener);
		//btn_get_speakervol.setOnClickListener(clicklistener);
		//btn_set_hummervol.setOnClickListener(clicklistener);
		//btn_get_hummervol.setOnClickListener(clicklistener);
		//btn_set_camear.setOnClickListener(clicklistener);
		//btn_set_phone.setOnClickListener(clicklistener);
		//btn_set_sms.setOnClickListener(clicklistener);				
		//btn_set_browser.setOnClickListener(clicklistener);
		btn_set_installapkblacklist.setOnClickListener(clicklistener);
		btn_get_installapkblacklist.setOnClickListener(clicklistener);
		btn_installapkblacklist.setOnClickListener(clicklistener);
		btn_packagename.setOnClickListener(clicklistener);
		btn_uninstallapkbyname.setOnClickListener(clicklistener);
		_tv.setText("logout here...");
		
		
	}
	
	

	@Override
	protected void onDestroy() {
		this.unregisterReceiver(this.mReceiver);
		super.onDestroy();

		osModule.CloseMonitor();
		if(null != mWakeLock){   
            mWakeLock.release();   
        } 
	}
	
	@Override   
    protected void onResume() {   
        super.onResume();                        
    }   
       
    @Override   
    protected void onPause() {   
        super.onPause();   
           
    }

	

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler(){

		public void handleMessage(Message msg) {
			String message=null;
			switch (msg.what) {

			case Gather.HANDLER_WHAT_FOR_BROADCAST_RECEIVER:
				
				Bundle bundle = msg.getData();
				
				Log.e(tag, "============================"+bundle.getInt("Result", -1));
				
				if (bundle.getInt("Result", -1) == -1){
					/*_tv.append("\n操作失败，出错信息："
							+ "时间戳" + bundle.getLong("Timestamp", -1) + ","
							+ "请求命令" + bundle.getInt("Cmd", -1) + ","
							+ "错误码" + bundle.getInt("Errorcode", -1) + ","
							+ "错误信息" + bundle.getString("Errormsg")
							+ ".");*/
					Log.e(tag, "\n操作失败，出错信息："
							+ "时间戳" + bundle.getLong("Timestamp", -1) + ","
							+ "请求命令" + bundle.getInt("Cmd", -1) + ","
							+ "错误码" + bundle.getInt("Errorcode", -1) + ","
							+ "错误信息" + bundle.getString("Errormsg")
							+ ".");
					
					message="\n操作失败，出错信息："
							+ "时间戳" + bundle.getLong("Timestamp", -1) + ","
							+ "请求命令" + bundle.getInt("Cmd", -1) + ","
							+ "错误码" + bundle.getInt("Errorcode", -1) + ","
							+ "错误信息" + bundle.getString("Errormsg")
							+ ".";
					refreshLogView(message);
					break;
				}
				
				Log.e(tag,"CMD=="+bundle.getInt("Cmd", -1));
				
				switch (bundle.getInt("Cmd", -1)) {
				
				case Gather.CMD_SYSTEM_GET_APILEVEL:
					//_tv.append("\n协议版本为："+bundle.getInt("Status", -1));
					message="\n协议版本为："+bundle.getInt("Status", -1);
					refreshLogView(message);
					break;			

				case Gather.CMD_SYSTEM_GET_DEVICETYPE:
					//_tv.append("\n设备型号为："+bundle.getString("Data"));
					message="\n设备型号为："+bundle.getString("Data");
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_GET_DEVICESIGN:
					//_tv.append("\n机器SN码为："+bundle.getString("Data"));
					message="\n机器SN码为："+bundle.getString("Data");
					//message="\n获取IMEI码为："+bundle.getString("Data");
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_SET_REBOOT:
					//_tv.append("\n设置重启成功");
					message="\n设置重启成功";
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_SET_SHUTDOWN:
					//_tv.append("\n设置关机成功");
					message="\n设置关机成功";
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_SET_TIME:
					//_tv.append("\n设置时间成功");
					message="\n设置时间成功";
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_SET_BAREXPAND:
					//_tv.append("\n设置下拉栏成功");
					message="\n设置下拉栏成功";
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_GET_BAREXPAND:
					int tmp = bundle.getInt("Status", -1);
					if (tmp == 1){
						//_tv.append("\n不允许下拉栏下拉");
						message="\n不允许下拉栏下拉";
						refreshLogView(message);
					} else if (tmp == 0){
						//_tv.append("\n允许下拉栏下拉");
						message="\n允许下拉栏下拉";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;

				case Gather.CMD_SYSTEM_SET_USBDEBUG:
					//_tv.append("\n设置USB调试状态成功");
					message="\n设置USB调试状态成功";
					refreshLogView(message);
					break;				

				case Gather.CMD_SYSTEM_GET_USBDEBUG:
					int tmp1 = bundle.getInt("Status", -1);
					if (tmp1 == 1){
						//_tv.append("\n不允许USB调试");
						message="\n不允许USB调试";
						refreshLogView(message);
					} else if (tmp1 == 0){
						//_tv.append("\n允许USB调试");
						message="\n允许USB调试";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;

				case Gather.CMD_SYSTEM_GET_SWITCHKEYBOARD:
					//_tv.append("\n设置英文/数字切换按键成功");
					message="\n设置英文/数字切换按键成功";
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_SET_APKINSTALLWHITELIST:
					//_tv.append("\n设置APK白名单成功");
					message="\n设置APK白名单成功";
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_GET_APKINSTALLWHITELIST:
					int tmp2 = bundle.getInt("Status", -1);
					Log.e(tag, "tmp2=============="+tmp2);
					if (tmp2 == 1){
						//_tv.append("\nAPK白名单未开启");
						message="\nAPK白名单未开启";
						refreshLogView(message);
					} else if (tmp2 == 0){
						//_tv.append("\nAPK白名单已开启");
						message="\nAPK白名单已开启";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;

				case Gather.CMD_SYSTEM_SET_UPDATAAPKWHITELIST:
					//_tv.append("\n设置更新APK白名单成功");
					message="\n设置更新APK白名单成功";
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_SET_APKINSTALLUI:
					//_tv.append("\n设置APK安装界面成功");
					message="\n设置APK安装界面成功";
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_SET_APKINSTALLAWITHSILENCE:
					//_tv.append("\n设置APK静默选项成功");
					message="\n设置APK静默选项成功";
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_SET_APKUNINSTALL:
					//_tv.append("\n设置是否允许APK卸载成功");
					message="\n设置是否允许APK卸载成功";
					refreshLogView(message);
					break;

				case Gather.CMD_SYSTEM_GET_APKUNINSTALL:
					int tmp3 = bundle.getInt("Status", -1);
					if (tmp3 == 1){
						//_tv.append("\n不允许卸载APK");
						message="\n不允许卸载APK";
						refreshLogView(message);
					} else if (tmp3 == 0){
						//_tv.append("\n允许APK卸载");
						message="\n允许APK卸载";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;

				case Gather.CMD_FOTA_SET_OSUPDATA:
					//_tv.append("\n设置更新OS成功");
					message="\n设置更新OS成功";
					refreshLogView(message);
					break;
					
				case Gather.CMD_SYSTEM_RESET:
					//_tv.append("\n设置更新OS成功");
					int status = bundle.getInt("Status", -1);
					if(status==0){
						message="\n不设置恢复出厂设置";
						refreshLogView(message);
					}else if(status==1){
						message="\n恢复出厂设置成功";
						refreshLogView(message);
					}
					
					break;
					
				case Gather.CMD_SYSTEM_SET_MENUENABLE:
					//_tv.append("\n设置HOME使能成功");
					message="\n设置HOME使能成功";
					refreshLogView(message);
					break;
					
				case Gather.CMD_SYSTEM_GET_MENUENABLE:
					int tmp4 = bundle.getInt("Status", -1);
					if (tmp4 == 0){
						//_tv.append("\nHOME使能打开");
						message="\nHOME使能打开";
						refreshLogView(message);
					} else if (tmp4 == 1){
						//_tv.append("\nHOME使能关闭");
						message="\nHOME使能关闭";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;	
					
				case Gather.CMD_SYSTEM_SET_DATAROAM:
					//_tv.append("\n设置漫游状态");
					message="\n设置漫游状态";
					refreshLogView(message);
					break;
					
				case Gather.CMD_SYSTEM_GET_DATAROAM:
					int tmp5 = bundle.getInt("Status", -1);
					if(tmp5 == 0){
						//_tv.append("\n漫游打开");
						message="\n漫游打开";
						refreshLogView(message);
					} else if(tmp5 == 1){
						//_tv.append("\n漫游关闭");
						message="\n漫游关闭";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_SYSTEM_SET_KEYBOARDSOUND:
					//_tv.append("\n设置按键音成功");
					message="\n设置按键音成功";
					refreshLogView(message);
					break;
				case Gather.CMD_SYSTEM_GET_KEYBOARDSOUND:
					int tmp6 = bundle.getInt("Status", -1);
					if(tmp6 == 0){
						//_tv.append("\n开启声音");
						message="\n开启声音";
						refreshLogView(message);
					} else if(tmp6 == 1){
						//_tv.append("\n关闭声音");
						message="\n关闭声音";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_SYSTEM_SET_KEYBOARDWAKEUP:
					//_tv.append("\n设置按键音成功");
					message="\n设置任意键唤醒成功";
					refreshLogView(message);
					break;
				case Gather.CMD_SYSTEM_GET_KEYBOARDWAKEUP:
					int tmp7 = bundle.getInt("Status", -1);
					if(tmp7 == 0){
						//_tv.append("\n任意键唤醒开启");
						message="\n任意键唤醒开启";
						refreshLogView(message);
					} else if(tmp7 == 1){
						//_tv.append("\n任意键唤醒关闭");
						message="\n任意键唤醒关闭";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_SYSTEM_SET_UNAPKINSTALLUI:
					//_tv.append("\n设置APK卸载界面成功");
					message="\n设置APK卸载界面成功";
					refreshLogView(message);
					break;				
				case Gather.CMD_SYSTEM_GET_UNAPKINSTALLUI:
					int tmp8 = bundle.getInt("Status", -1);
					if(tmp8 == 0){
						//_tv.append("\n系统默认卸载界面");
						message="\n系统默认卸载界面";
						refreshLogView(message);
					} else if(tmp8 == 1){
						//_tv.append("\n静默卸载");
						message="\n静默卸载";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_FOTA_GET_ROMUID	:
					//_tv.append("\nROM_UID为："+bundle.getInt("Status", -1));
					message="\nROM_UID为："+bundle.getString("Data");
					refreshLogView(message);
					break;	
				case Gather.CMD_FOTA_GET_ROMVER		:
					//_tv.append("\nROM_VER为："+bundle.getInt("Status", -1));
					message="\nROM_VER为："+bundle.getInt("Status",-1);
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_SET_GPS:
					//_tv.append("\n设置GPS成功");
					message="\n设置GPS成功";
					refreshLogView(message);
					break;

				case Gather.CMD_MODULE_GET_GPS:
					int tmp9 = bundle.getInt("Status", -1);					
					if (tmp9 == 1){
						//_tv.append("\n不允许USB调试");
						message="\n模块打开且可见";
						refreshLogView(message);
					} else if (tmp9 == 2){
						//_tv.append("\n允许USB调试");
						message="\n模块关闭且可见";
						refreshLogView(message);
					} else if (tmp9 == 3){
						//_tv.append("\n允许USB调试");
						message="\n模块打开且不可见";
						refreshLogView(message);
					}else if (tmp9 == 4){
						//_tv.append("\n允许USB调试");
						message="\n模块关闭且不可见";
						refreshLogView(message);
					}else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_MODULE_SET_WIFI:
					//_tv.append("\n设置GPS成功");
					message="\n设置WIFI成功";
					refreshLogView(message);
					break;

				case Gather.CMD_MODULE_GET_WIFI:
					int tmp10 = bundle.getInt("Status", -1);					
					if (tmp10 == 1){
						//_tv.append("\n不允许USB调试");
						message="\n模块打开且可见";
						refreshLogView(message);
					} else if (tmp10 == 2){
						//_tv.append("\n允许USB调试");
						message="\n模块关闭且可见";
						refreshLogView(message);
					} else if (tmp10 == 3){
						//_tv.append("\n允许USB调试");
						message="\n模块打开且不可见";
						refreshLogView(message);
					}else if (tmp10 == 4){
						//_tv.append("\n允许USB调试");
						message="\n模块关闭且不可见";
						refreshLogView(message);
					}else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_MODULE_SET_BLUETOOTH:
					//_tv.append("\n设置GPS成功");
					message="\n设置蓝牙成功";
					refreshLogView(message);
					break;

				case Gather.CMD_MODULE_GET_BLUETOOTH:
					int tmp11 = bundle.getInt("Status", -1);					
					if (tmp11 == 1){
						//_tv.append("\n不允许USB调试");
						message="\n模块打开且可见";
						refreshLogView(message);
					} else if (tmp11 == 2){
						//_tv.append("\n允许USB调试");
						message="\n模块关闭且可见";
						refreshLogView(message);
					} else if (tmp11 == 3){
						//_tv.append("\n允许USB调试");
						message="\n模块打开且不可见";
						refreshLogView(message);
					}else if (tmp11 == 4){
						//_tv.append("\n允许USB调试");
						message="\n模块关闭且不可见";
						refreshLogView(message);
					}else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_MODULE_SET_MOBILEDATA:
					//_tv.append("\n设置GPS成功");
					message="\n设置移动网络3G/4G成功";
					refreshLogView(message);
					break;

				case Gather.CMD_MODULE_GET_MOBLIEDATA:
					int tmp12 = bundle.getInt("Status", -1);
					Log.e(tag, "++++++++++++++++++++++++"+bundle.getInt("Status", -1));
					if (tmp12 == 1){
						//_tv.append("\n不允许USB调试");
						message="\n模块打开且可见";
						refreshLogView(message);
					} else if (tmp12 == 2){
						//_tv.append("\n允许USB调试");
						message="\n模块关闭且可见";
						refreshLogView(message);
					} else if (tmp12 == 3){
						//_tv.append("\n允许USB调试");
						message="\n模块打开且不可见";
						refreshLogView(message);
					}else if (tmp12 == 4){
						//_tv.append("\n允许USB调试");
						message="\n模块关闭且不可见";
						refreshLogView(message);
					}else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_MODULE_SET_EARPHONEVOL:
					//_tv.append("\n设置GPS成功");
					Log.e(tag, "----------------------------");
					message="\n设置听筒音量成功";
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_GET_EARPHONEVOL:
					//_tv.append("\n设置GPS成功");	
					Log.e(tag, "----------------------------");
					message="\n获取听筒音量为："+bundle.getInt("Status", -1);
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_SET_SPEAKERVOL:
					//_tv.append("\n设置GPS成功");
					Log.e(tag, "----------------------------");
					message="\n设置扬声器音量";
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_GET_SPEAKERVOL:
					//_tv.append("\n设置GPS成功");	
					Log.e(tag, "----------------------------");
					message="\n获取扬声器音量为："+bundle.getInt("Status", -1);
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_SET_HUMMERVOL:
					Log.e(tag, "----------------------------");
					//_tv.append("\n设置GPS成功");
					message="\n设置蜂鸣器音量";
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_GET_HUMMERVOL:
					Log.e(tag, "----------------------------");
					//_tv.append("\n设置GPS成功");					
					message="\n获取蜂鸣器音量为："+bundle.getInt("Status", -1);
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_SET_CAMERA:
					Log.e(tag, "----------------------------");
					//_tv.append("\n设置GPS成功");					
					message="\n获取摄像头成功";
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_SET_PHONE:
					Log.e(tag, "----------------------------");
					//_tv.append("\n设置GPS成功");					
					message="\n获取设置电话成功";
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_SET_SMS:
					Log.e(tag, "----------------------------");
					//_tv.append("\n设置GPS成功");					
					message="\n获取设置短信成功";
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_SET_BROWSER:
					Log.e(tag, "----------------------------");
					//_tv.append("\n设置GPS成功");					
					message="\n获取设置浏览器成功";
					refreshLogView(message);
					break;
					
				case Gather.CMD_SYSTEM_SET_INSTALLAPKBLACKLIST:
					//_tv.append("\n设置GPS成功");
					message="\n设置启用APK黑名单成功";
					refreshLogView(message);
					break;
				case Gather.CMD_SYSTEM_GET_INSTALLAPKBLACKLIST :
					int tmp13 = bundle.getInt("Status", -1);
					Log.e(tag, "++++++++++++++++++++++++"+bundle.getInt("Status", -1));
					if (tmp13 == 1){
						//_tv.append("\n不允许USB调试");
						message="\n获取APK黑名单未开启";
						refreshLogView(message);
					} else if (tmp13 == 0){
						//_tv.append("\n允许USB调试");
						message="\n获取APK黑名单已开启";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				
				case Gather.CMD_SYSTEM_CLEAN_APP_DATA:
					message="\n清除数据成功";
					Log.e("tag", "message=="+message);
					refreshLogView(message);
					break;
				case Gather.CMD_SYSTEM_INSTALLAPKBLACKLIST:
					int tmp14 = bundle.getInt("Status", -1);
					//Log.e(tag, "tmp2=============="+tmp2);
					if (tmp14 == 0){
						//_tv.append("\nAPK白名单未开启");
						message="\n添加、删除成功";
						refreshLogView(message);
					} else if (tmp14 == 1){
						//_tv.append("\nAPK白名单已开启");
						message="\n添加、删除失败";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_SYSTEM_UNAPKINSTALL:
					int tmp15 = bundle.getInt("Status", -1);
					if(tmp15==0){
						message="\n卸载完成";
						refreshLogView(message);
					}else if(tmp15==1){
						message="\n卸载失败";
						refreshLogView(message);
					}else{
						message="\n未知的状态";
						refreshLogView(message);
					}					
					break;
				case Gather.CMD_SYSTEM_RESET_SET:
					//_tv.append("\n设置GPS成功");
					message="\n设置系统恢复默认";
					refreshLogView(message);
					break;
				case Gather.CMD_SYSTEM_RESET_GET :
					int tmp16 = bundle.getInt("Status", -1);
					Log.e(tag, "++++++++++++++++++++++++"+bundle.getInt("Status", -1));
					if (tmp16 == 1){
						//_tv.append("\n不允许USB调试");
						message="\n开启系统恢复默认服务";
						refreshLogView(message);
					} else if (tmp16 == 0){
						//_tv.append("\n允许USB调试");
						message="\n关闭系统恢复默认服务";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_MODULE_APP_ACCESSIBILITY_SET_POWER_OPTIMIZATION:
					//_tv.append("\n设置GPS成功");
					message="\n设置应用耗电优化状态";
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_APP_ACCESSIBILITY_GET_POWER_OPTIMIZATION :
					int tmp17 = bundle.getInt("Status", -1);
					Log.e(tag, "++++++++++++++++++++++++"+bundle.getInt("Status", -1));
					if (tmp17 == 1){
						//_tv.append("\n不允许USB调试");
						message="\n开启开启耗电优化";
						refreshLogView(message);
					} else if (tmp17 == 0){
						//_tv.append("\n允许USB调试");
						message="\n关闭耗电优化";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_MODULE_APP_ACCESSIBILITY_SET:
					//_tv.append("\n设置GPS成功");
					message="\n设置应用辅助功能";
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_APP_ACCESSIBILITY_GET :
					int tmp19 = bundle.getInt("Status", -1);
					Log.e(tag, "++++++++++++++++++++++++"+bundle.getInt("Status", -1));
					if (tmp19 == 1){
						//_tv.append("\n不允许USB调试");
						message="\n开启应用辅助功能";
						refreshLogView(message);
					} else if (tmp19 == 0){
						//_tv.append("\n允许USB调试");
						message="\n关闭应用辅助功能";
						refreshLogView(message);
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				case Gather.CMD_MODULE_APP_RESIDENT_BACKSTAGE_SET:
					//_tv.append("\n设置GPS成功");
					message="\n设置应用包名列表成功";
					refreshLogView(message);
					break;
				case Gather.CMD_MODULE_APP_RESIDENT_BACKSTAGE_GETLIST :
					String tmp18 = bundle.getString("PackageNames");
					Log.e(tag, "++++++++++++++++++++++++"+tmp18);
					if (tmp18!= null){
						//_tv.append("\n不允许USB调试");
						message="\n"+tmp18;
						refreshLogView(message);					
					} else {
						//_tv.append("\n未知的状态");
						message="\n未知的状态";
						refreshLogView(message);
					}
					break;
				default:
					break;
				}
			}
		}
	};

	void refreshLogView(String message){
        _tv.append(message);
        int offset=_tv.getLineCount()*_tv.getLineHeight();
        if(offset>_tv.getHeight()){
        	_tv.scrollTo(0,offset-_tv.getHeight());
        }
    }
	
	private class ClickListener implements OnClickListener {

		@Override
		public void onClick(View view) {

			AlertDialog.Builder builder = new AlertDialog.Builder(MainView.this);
			builder.setTitle("可选设置");

			switch (view.getId()) {

			case R.id.button1:
				
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_APILEVEL);
				break;			

			case R.id.button2:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_DEVICETYPE);
				break;

			case R.id.button3:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_DEVICESIGN, "Option", 1);
				break;

			case R.id.button4:
				builder.setTitle("提示").setMessage("确定重启？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_REBOOT);
					}
				}).show();
				break;

			case R.id.button5:
				builder.setTitle("提示").setMessage("确定关机？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_SHUTDOWN);
					}
				}).show();
				break;

			case R.id.button6:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_TIME, "Milliseconds", new Date().getTime());
				break;

			case R.id.button7:
				builder.setItems(new String[]{"允许下拉", "不允许下拉"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_BAREXPAND, "Enable", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_BAREXPAND, "Enable", 1);
						}
					}
				}).show();
				break;

			case R.id.button8:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_BAREXPAND);
				break;

			case R.id.button9:
				builder.setItems(new String[]{"允许调试", "不允许调试"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_USBDEBUG, "Enable", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_USBDEBUG, "Enable", 1);
						}
					}
				}).show();
				break;

			case R.id.button10:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_USBDEBUG);
				break;
			/*
			case R.id.button11:
				builder.setItems(new String[]{"切换到数字按键", "切换到英文小写按键", "切换到英文大写按键"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_SWITCHKEYBOARD, "Mode", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_SWITCHKEYBOARD, "Mode", 1);
						} else if (arg1 == 2){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_SWITCHKEYBOARD, "Mode", 2);
						}
					}
				}).show();
				break;
			 */
			case R.id.button12:
				builder.setItems(new String[]{"开", "关"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_APKINSTALLWHITELIST, "Mode", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_APKINSTALLWHITELIST, "Mode", 1);
						}
					}
				}).show();
				break;

			case R.id.button13:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_APKINSTALLWHITELIST);
				break;
			/*
			case R.id.button14:
				String WHITELISTPATH = Gather.WHITELISTDIR;
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_UPDATAAPKWHITELIST, "Path", Environment.getExternalStorageDirectory().getPath()+WHITELISTPATH);
				break;

			case R.id.button15:
				builder.setItems(new String[]{"系统默认安装界面", "静默安装"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_APKINSTALLUI, "Option", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_APKINSTALLUI, "Option", 1);
						}
					}
				}).show();
				break;
			*/
			case R.id.button16:
				builder.setItems(new String[]{"系统默认安装后不运行", "安装后自动运行"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_APKINSTALLAWITHSILENCE, "Option", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_APKINSTALLAWITHSILENCE, "Option", 1);
						}
					}
				}).show();
				break;

			case R.id.button17:
				builder.setItems(new String[]{"允许卸载", "不允许卸载"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_APKUNINSTALL, "Enable", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_APKUNINSTALL, "Enable", 1);
						}
					}
				}).show();
				break;

			case R.id.button18:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_APKUNINSTALL);
				break;

			case R.id.button19:
				builder.setItems(new String[]{"IMG完整包", "IMG差分包"}, new DialogInterface.OnClickListener() {

					String OSPATH = Gather.OSDIR;
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_FOTA_SET_OSUPDATA, "Type", 0, "Path", "/storage/72AD-2013/update.zip");
							Log.e("tag", "path==="+Environment.getExternalStorageDirectory().getPath()+"/update.zip");
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_FOTA_SET_OSUPDATA, "Type", 1, "Path", Environment.getExternalStorageDirectory().getPath()+"/update.zip");
						}
					}
				}).show();
				break;
			
			case R.id.button20:
				_tv.setText("");
				break;		
			case R.id.btn_sethome:
				builder.setItems(new String[]{"HOME键使能", "HOME键屏蔽"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_MENUENABLE, "Enable", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_MENUENABLE, "Enable", 1);
						}
					}
				}).show();
				break;
				
			case R.id.btn_gethome:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_MENUENABLE);
				break;
				
			case R.id.btn_setSound:
				builder.setItems(new String[]{"开启声音", "关闭声音"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_KEYBOARDSOUND, "Enable", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_KEYBOARDSOUND, "Enable", 1);
						}
					}
				}).show();
				break;
			case R.id.btn_getSound:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_KEYBOARDSOUND);
				break;
			/*
			case R.id.btn_set_keyboardwakeUp:
				builder.setItems(new String[]{"开启任意键唤醒", "关闭任意键唤醒"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_KEYBOARDWAKEUP, "Enable", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_KEYBOARDWAKEUP, "Enable", 1);
						}
					}
				}).show();
				break;
				
			case R.id.btn_get_keyboardwakeUp:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_KEYBOARDWAKEUP);
				break;
				*/
			case R.id.btn_set_unapkinstallui:
				builder.setItems(new String[]{"系统默认卸载界面", "静默卸载"}, new DialogInterface.OnClickListener() {					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_UNAPKINSTALLUI, "Option", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_UNAPKINSTALLUI, "Option", 1);
						}
					}
				}).show();
				break;
			case R.id.btn_uninstallapkbyname:
				builder.setItems(new String[]{"系统默认卸载界面", "静默卸载"}, new DialogInterface.OnClickListener() {					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_UNAPKINSTALL, "Mode", 0,"Path","com.example.irscandemo");
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_UNAPKINSTALL, "Mode", 1,"Path","com.example.irscandemo");
						}
					}
				}).show();
				break;
			case R.id.btn_get_unapkinstallui:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_UNAPKINSTALLUI);
				break;
			case R.id.btn_get_romuid:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_FOTA_GET_ROMUID);
				break;
			case R.id.btn_get_romver:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_FOTA_GET_ROMVER	);
				break;
			case R.id.btn_set_gps:
				builder.setItems(new String[]{"模块打开且可见", "模块关闭且可见","模块打开且不可见","模块关闭且不可见"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_GPS, "Option", 1);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_GPS, "Option", 2);
						}
						else if (arg1 == 2){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_GPS, "Option", 3);
						}
						else if (arg1 == 3){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_GPS, "Option", 4);
						}
					}
				}).show();
				break;
			case R.id.btn_get_gps:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_GET_GPS);
				break;
			case R.id.btn_set_wifi:
				builder.setItems(new String[]{"模块打开且可见", "模块关闭且可见","模块打开且不可见","模块关闭且不可见"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_WIFI	, "Option", 1);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_WIFI	, "Option", 2);
						}
						else if (arg1 == 2){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_WIFI	, "Option", 3);
						}
						else if (arg1 == 3){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_WIFI	, "Option", 4);
						}
					}
				}).show();
				break;
			case R.id.btn_get_wifi:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_GET_WIFI	);
				break;
			case R.id.btn_set_bluetooth:
				builder.setItems(new String[]{"模块打开且可见", "模块关闭且可见","模块打开且不可见","模块关闭且不可见"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_BLUETOOTH	, "Option", 1);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_BLUETOOTH	, "Option", 2);
						}
						else if (arg1 == 2){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_BLUETOOTH	, "Option", 3);
						}
						else if (arg1 == 3){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_BLUETOOTH	, "Option", 4);
						}
					}
				}).show();
				break;
			case R.id.btn_get_bluetooth:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_GET_BLUETOOTH);
				break;
				/*
			case R.id.btn_set_mobiledata:
				builder.setItems(new String[]{"模块打开且可见", "模块关闭且可见","模块打开且不可见","模块关闭且不可见"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_MOBILEDATA	, "Option", 1);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_MOBILEDATA	, "Option", 2);
						}
						else if (arg1 == 2){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_MOBILEDATA	, "Option", 3);
						}
						else if (arg1 == 3){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_MOBILEDATA	, "Option", 4);
						}
					}
				}).show();
				break;
				
			case R.id.btn_get_mobiledata:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_GET_MOBLIEDATA);
				break;
			case R.id.btn_set_earphonevol:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_EARPHONEVOL,"Level",100);
				break;
			case R.id.btn_get_earphonevol:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_GET_EARPHONEVOL);
				break;			
			case R.id.btn_set_speakervol:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_GET_SPEAKERVOL,"Level",100);
				break;
			case R.id.btn_get_speakervol:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_GET_SPEAKERVOL);
				break;
			case R.id.btn_set_hummervol:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_HUMMERVOL,"Level",100);
				break;
			case R.id.btn_get_hummervol:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_GET_HUMMERVOL);
				break;
			case R.id.btn_set_camear:
				builder.setItems(new String[]{"可用", "不可用"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_CAMERA, "Enable", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_CAMERA, "Enable", 1);
						}
					}
				}).show();
				break;
			case R.id.btn_set_phone:
				builder.setItems(new String[]{"可用", "不可用"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_PHONE, "Enable", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_PHONE, "Enable", 1);
						}
					}
				}).show();
				break;
				
			case R.id.btn_set_sms:
				builder.setItems(new String[]{"可用", "不可用"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_SMS, "Enable", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_SMS, "Enable", 1);
						}
					}
				}).show();
				break;
			case R.id.btn_set_browser:
				builder.setItems(new String[]{"可用", "不可用"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_BROWSER, "Enable", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_SET_BROWSER, "Enable", 1);
						}
					}
				}).show();
				break;
				*/
			case R.id.btn_set_installapkblacklist:
				builder.setItems(new String[]{"开", "关"}, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_INSTALLAPKBLACKLIST, "Mode", 0);
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_SET_INSTALLAPKBLACKLIST, "Mode", 1);
						}
					}
				}).show();
				break;
			case R.id.btn_get_installapkblacklist:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_GET_INSTALLAPKBLACKLIST);
				break;				
			case R.id.btn_installapkblacklist:
				builder.setItems(new String[]{"向黑名单添加apk信息", "删除黑名单已经存在的apk信息"}, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_INSTALLAPKBLACKLIST, "Mode", 0,"package","com.example.scarx.idcarder");
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_INSTALLAPKBLACKLIST, "Mode", 1,"package","com.example.scarx.idcarder");
						}
					}
				}).show();
			case R.id.make_clear:
				builder.setItems(new String[]{"不格式化", "格式化内部存储空间"}, new DialogInterface.OnClickListener() {

					String OSPATH = Gather.OSDIR;
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_RESET, "FormatInternalStorage", 0);						
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_RESET, "FormatInternalStorage", 1);
						}
					}
				}).show();
				break;
				
			case R.id.btn_set_system_reset:
				builder.setItems(new String[]{"关闭复位功能", "开启服务功能"}, new DialogInterface.OnClickListener() {

					String OSPATH = Gather.OSDIR;
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_RESET_SET, "Enable", 0);						
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_RESET_SET, "Enable", 1);
						}
					}
				}).show();
				break;
			case R.id.btn_get_system_reset:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_RESET_GET);
				break;
			
			case R.id.btn_set_power_optimization:
				builder.setItems(new String[]{"关闭耗电优化", "开启耗电优化"}, new DialogInterface.OnClickListener() {

					String OSPATH = Gather.OSDIR;
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.	
									CMD_MODULE_APP_ACCESSIBILITY_SET_POWER_OPTIMIZATION,"Enable", 0,"PackageName","com.example.scarx.idcarder");						
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.
									CMD_MODULE_APP_ACCESSIBILITY_SET_POWER_OPTIMIZATION,"Enable", 1,"PackageName","com.example.scarx.idcarder");
						}
					}
				}).show();
				break;
			case R.id.btn_get_power_optimization:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_APP_ACCESSIBILITY_SET_POWER_OPTIMIZATION,"PackageName","com.example.scarx.idcarder");
				break;
				
			case R.id.btn_set_app_accessibility:
				builder.setItems(new String[]{"关闭应用辅助功能", "开启应用辅助功能"}, new DialogInterface.OnClickListener() {

					String OSPATH = Gather.OSDIR;
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_APP_ACCESSIBILITY_SET,"Enable", 0,"PackageName","com.example.scarx.idcarder");						
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_APP_ACCESSIBILITY_SET,"Enable", 1,"PackageName","com.example.scarx.idcarder");
						}
					}
				}).show();
				break;
			case R.id.btn_get_app_accessibility:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_APP_ACCESSIBILITY_GET,"PackageName","com.example.scarx.idcarder");
				Log.e(tag, "Gather.CMD_MODULE_APP_ACCESSIBILITY_GET=="+Gather.CMD_MODULE_APP_ACCESSIBILITY_GET);
				break;
			case R.id.btn_set_resident_backstage:
				builder.setItems(new String[]{"删除应用", "添加应用"}, new DialogInterface.OnClickListener() {

					String OSPATH = Gather.OSDIR;
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_APP_RESIDENT_BACKSTAGE_SET,"Method", 0,"PackageNames","com.example.scarx.idcarder");						
						} else if (arg1 == 1){
							osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_APP_RESIDENT_BACKSTAGE_SET,"Method", 1,"PackageNames","com.example.scarx.idcarder");
						}
					}
				}).show();
				break;
			case R.id.btn_get_resident_backstage:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_MODULE_APP_RESIDENT_BACKSTAGE_GETLIST);
				break;
				
			case R.id.btn_packagename:
				osModule.SendBroadcast(new Date().getTime(), Gather.CMD_SYSTEM_CLEAN_APP_DATA,"PackageName","com.idata.mdm");
				break;				
			default:
				break;
			}
		}

	}
	
	private void registerBroadcast() {
	      IntentFilter var1 = new IntentFilter();
	      var1.addAction("com.idatachina.SYS02event");
	      var1.addAction("com.idatachina.SCANKEYEVENT");
	      this.registerReceiver(this.mReceiver, var1);
	   }
	
	
	private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
	      public void onReceive(Context context, Intent intent) {
	         
	         if(intent.getAction().equals("com.idatachina.SYS02event")){
	        	 //此处进行相应操作
	        	
	        	 Log.e(tag, "111111111111111111111111111");	
	        	 
	         }else if(intent.getAction().equals("com.idatachina.SCANKEYEVENT")){
	        	 Log.e(tag, "222222222222222222222222222");	
	         }	      
	      }
	};
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			moveTaskToBack(false);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
