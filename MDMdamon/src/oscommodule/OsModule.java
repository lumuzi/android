package oscommodule;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import oscommodule.Gather;

public class OsModule {

	private Context mcontext;
	private Handler mhandler;
	private BroadcastReceiver mBroadcastReceiver;

	/*
	 * �������ܣ��๹�캯������ʼ�� ���������������context����Ϣ���handler ���������void
	 */
	public OsModule(Context context, Handler handler) {
				
		mcontext = context;
		mhandler = handler;
		int result=checkdir();
	}

	/*
	 * �������ܣ��򿪹㲥����������ע������� ���������void ���������void
	 */
	public void OpenMonitor() {

		mBroadcastReceiver = new Receive();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Gather.RESPONE);
		mcontext.registerReceiver(mBroadcastReceiver, intentFilter);
	}

	/*
	 * �������ܣ��رչ㲥������������ע������� ���������void ���������void
	 */
	public void CloseMonitor() {

		mcontext.unregisterReceiver(mBroadcastReceiver);
	}

	/*
	 * �������ܣ����͹㲥 ���������ʱ���timestamp����������cmd ���������void
	 */
	public void SendBroadcast(long timestamp, int cmd) {

		
		Intent _intent = new Intent(Gather.REQUEST);
		
		_intent.putExtra("Timestamp", timestamp);
		_intent.putExtra("Cmd", cmd);

		mcontext.sendBroadcast(_intent);
		
		writetolog(Gather.REQUEST, timestamp, cmd, "null", "null", "null", "null");
		
	}

	/*
	 * �������ܣ����͹㲥�Ķ�̬���� ���������ʱ���timestamp����������cmd���������para���������ֵvalue ���������void
	 */
	public void SendBroadcast(long timestamp, int cmd, String para, int value) {
		Intent _intent = new Intent(Gather.REQUEST);

		_intent.putExtra("Timestamp", timestamp);
		_intent.putExtra("Cmd", cmd);
		_intent.putExtra(para, value);

		mcontext.sendBroadcast(_intent);
		writetolog(Gather.REQUEST, timestamp, cmd, para, String.valueOf(value), "null", "null");
	}

	/*
	 * �������ܣ����͹㲥�Ķ�̬���� ���������ʱ���timestamp����������cmd���������para���������ֵvalue ���������void
	 */
	public void SendBroadcast(long timestamp, int cmd, String para, boolean value) {
		Intent _intent = new Intent(Gather.REQUEST);

		_intent.putExtra("Timestamp", timestamp);
		_intent.putExtra("Cmd", cmd);
		_intent.putExtra(para, value);

		mcontext.sendBroadcast(_intent);
		writetolog(Gather.REQUEST, timestamp, cmd, para, String.valueOf(value), "null", "null");
	}

	/*
	 * �������ܣ����͹㲥�Ķ�̬���� ���������ʱ���timestamp����������cmd���������para���������ֵvalue ���������void
	 */
	public void SendBroadcast(long timestamp, int cmd, String para, long value) {
		Intent _intent = new Intent(Gather.REQUEST);

		_intent.putExtra("Timestamp", timestamp);
		_intent.putExtra("Cmd", cmd);
		_intent.putExtra(para, value);

		mcontext.sendBroadcast(_intent);
		writetolog(Gather.REQUEST, timestamp, cmd, para, String.valueOf(value), "null", "null");
	}

	/*
	 * �������ܣ����͹㲥�Ķ�̬���� ���������ʱ���timestamp����������cmd���������para���������ֵvalue ���������void
	 */
	public void SendBroadcast(long timestamp, int cmd, String para, String value) {
		Log.e("tag", "SendBroadcast1111111111111");
		Intent _intent = new Intent(Gather.REQUEST);

		_intent.putExtra("Timestamp", timestamp);
		_intent.putExtra("Cmd", cmd);
		_intent.putExtra(para, value);

		mcontext.sendBroadcast(_intent);
		writetolog(Gather.REQUEST, timestamp, cmd, para, value, "null", "null");
	}

	/*
	 * �������ܣ����͹㲥�Ķ�̬����
	 * ���������ʱ���timestamp����������cmd���������para1���������ֵvalue1���������para2���������ֵvalue2
	 * ���������void
	 */
	//para1:type
	//para2:path
	public void SendBroadcast(long timestamp, int cmd, String para1, int value1, String para2, String value2) {
		
		Log.e("tag", "value2==="+value2);
		Intent _intent = new Intent(Gather.REQUEST);

		_intent.putExtra("Timestamp", timestamp);
		_intent.putExtra("Cmd", cmd);
		_intent.putExtra(para1, value1);
		_intent.putExtra(para2, value2);
		
		mcontext.sendBroadcast(_intent);
		writetolog(Gather.REQUEST, timestamp, cmd, para1, String.valueOf(value1), para2, value2);
	}

	/*
	 * ����ܣ��㲥�����������չ㲥��������Ϣ
	 */
	private class Receive extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			Log.e("tag", "SendBroadcast33333333333333333");
			if (intent.getAction().equals(Gather.RESPONE)) {
				Log.e("tag", "SendBroadcast222222222222222");
				writetolog(Gather.RESPONE, intent.getLongExtra("Timestamp", -1), intent.getIntExtra("Cmd", -1),
						intent.getIntExtra("Result", -1), intent.getIntExtra("Status", -1),intent.getStringExtra("PackageNames"),
						intent.getStringExtra("Data"), intent.getIntExtra("Errorcode", -1),
						intent.getStringExtra("Errormessage"));
				
				if ((intent.getLongExtra("Timestamp", -1) > 0) && (intent.getIntExtra("Cmd", -1) > 0)) {
					Log.e("tag", "111111111111111111111111==="+intent.getIntExtra("Result", -1));
					Message msg = new Message();
					msg.what = Gather.HANDLER_WHAT_FOR_BROADCAST_RECEIVER;
					Bundle mbundle = new Bundle();
					mbundle.putLong("Timestamp", intent.getLongExtra("Timestamp", -1));
					mbundle.putInt("Cmd", intent.getIntExtra("Cmd", -1));
					mbundle.putInt("Result", intent.getIntExtra("Result", -1));
					mbundle.putString("PackageNames", intent.getStringExtra("PackageNames"));
					mbundle.putInt("Status", intent.getIntExtra("Status", -1));
					mbundle.putString("Data", intent.getStringExtra("Data"));
					mbundle.putInt("Errorcode", intent.getIntExtra("Errorcode", -1));
					mbundle.putString("Errormessage", intent.getStringExtra("Errormessage"));
					msg.setData(mbundle);
					mhandler.sendMessage(msg);
				}
			}
		}
	}

	/*
	 * �������ܣ���ѯĿ¼�Ƿ���ڣ��������򴴽� ���������void
	 * �������������ֵ0��ʾ�Ѵ��ڣ�����ֵ1��ʾĿ¼�����������´����ɹ�������ֵ2��ʾĿ¼����������´���ʧ��
	 */
	private int checkdir() {
		
		int result = 0;
		String[] PATH = { Gather.WHITELISTDIR,Gather.BLACKLISTDIR, Gather.OSDIR, Gather.LOGDIR };
		for (int i = 0; i < 4; i++) {
			File file = new File(Environment.getExternalStorageDirectory().getPath(), PATH[i]);
			if (!file.exists() && !file.isDirectory()) {
				if (file.mkdirs()) {
					result = 1;
				} else {
					result = 2;
				}
			}
		}
		return result;
	}

	/*
	 * �������ܣ�д����־�������Ĺ㲥��Ϣд����־
	 * ����������㲥����type��ʱ���timestamp����������cmd���������para1���������ֵvalue1���������para2��
	 * �������ֵvalue2 ���������void
	 */
	private void writetolog(String type, long timestamp, int cmd, String para1, String value1, String para2,
			String value2) {
		Log.e("tag","writetolog1111111111111");
		String LOGPATH = Gather.LOGDIR + "logfile.txt";
		BufferedWriter bWrite;
		try {
			bWrite = new BufferedWriter(
					new OutputStreamWriter(new BufferedOutputStream(new DataOutputStream(new FileOutputStream(
							new File(Environment.getExternalStorageDirectory().getPath(), LOGPATH), true)))));
			bWrite.write(type + ",");
			bWrite.write(timestamp + ",");
			bWrite.write(cmd + ",");
			bWrite.write(para1 + ",");
			bWrite.write(value1 + ",");
			bWrite.write(para2 + ",");
			bWrite.write(value2 + "\n");		
			bWrite.flush();
			bWrite.close();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * �������ܣ�д����־�Ķ�̬�������յ��Ĺ㲥��Ϣд����־
	 * ����������㲥����type��ʱ���timestamp����������cmd��ִ�н��result�����ز���status�����ز���data��
	 * ������errorcode��������ʾ��Ϣerrormsg ���������void
	 */
	private void writetolog(String type, long timestamp, int cmd, int result, int status,String packagename, String data, int errorcode,
			String errormsg) {

		String LOGPATH = Gather.LOGDIR + "logfile.txt";
		BufferedWriter bWrite;
		try {
			bWrite = new BufferedWriter(
					new OutputStreamWriter(new BufferedOutputStream(new DataOutputStream(new FileOutputStream(
							new File(Environment.getExternalStorageDirectory().getPath(), LOGPATH), true)))));
			bWrite.write(type + ",");
			bWrite.write(timestamp + ",");
			bWrite.write(cmd + ",");
			bWrite.write(result + ",");
			bWrite.write(status + ",");
			bWrite.write(packagename + ",");
			bWrite.write(data + ",");
			bWrite.write(errorcode + ",");
			bWrite.write(errormsg + "\n");
			bWrite.flush();
			bWrite.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
