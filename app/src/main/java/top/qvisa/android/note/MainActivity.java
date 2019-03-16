package top.qvisa.android.note;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyDatabaseHelper dbHelper;
    private Button mB_add_data;
    private Button mB_search;
    private EditText mEt_title;
    private EditText mEt_content;
    private RecyclerView mRecyclerView;
    private List<Note> mNoteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindID();
        SetOnclickListener();
        initData();
    }

    private void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        Adapter adapter = new Adapter(this, mNoteList);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Bt_add_data:
                if (mEt_title.getText().toString().equals("")) {
                    Toast.makeText(this, "ERROR!Title is Null", Toast.LENGTH_SHORT).show();
                } else {
                    if (mEt_content.getText().toString().equals("")) {
                        Toast.makeText(this, "ERROR!Content is Null", Toast.LENGTH_SHORT).show();
                    } else {

                        String title = mEt_title.getText().toString();
                        String content = mEt_content.getText().toString();
                        DAO dao = new DAO(this);
                        dao.insert(title, content);

                        mEt_title.setText("");
                        mEt_content.setText("");
                        Toast.makeText(this, "Add successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.Bt_search:
                DAO dao = new DAO(this);
                dao.query(mNoteList);
        }
    }

    public void SetOnclickListener() {
        mB_add_data.setOnClickListener(this);
        mB_search.setOnClickListener(this);
    }

    public void bindID() {
        mB_add_data = findViewById(R.id.Bt_add_data);
        mEt_content = findViewById(R.id.Et_content);
        mEt_title = findViewById(R.id.Et_title);
        mRecyclerView = findViewById(R.id.Rec_view);
        mB_search = findViewById(R.id.Bt_search);
    }
}



