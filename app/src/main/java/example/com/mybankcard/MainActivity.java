package example.com.mybankcard;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import example.com.mybankcard.views.BankCardTextWatcher;

public class MainActivity extends Activity {

    private EditText mEt;
    private EditText mEtTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEt = ((EditText) this.findViewById(R.id.mEdtBankCardNo));
        BankCardTextWatcher.bind(mEt);

        mEtTest = ((EditText) this.findViewById(R.id.et_test));
        mEtTest.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("111", "1=====================================================");
                Log.e("111", "1==beforeTextChanged , s==" + s.toString());
                Log.e("111", "1==beforeTextChanged ,start==" + start);
                Log.e("111", "1==beforeTextChanged ,count==" + count);
                Log.e("111", "1==beforeTextChanged ,after==" + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("111", "2==onTextChanged ,s==" + s.toString());
                Log.e("111", "2==onTextChanged ,start==" + start);
                Log.e("111", "2==onTextChanged ,count==" + count);
                Log.e("111", "2==onTextChanged ,before==" + before);

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("111", "3==afterTextChanged ,s==" + s.toString());

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
