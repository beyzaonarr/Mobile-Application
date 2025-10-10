package msku.ceng.madlab.week3;

// HATALIYDI: import static android.os.Build.VERSION_CODES_FULL.R;  // ❌ KALDIRILDI

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    List<Post> postList;
    LayoutInflater inflater;

    public PostAdapter(Activity activity, List<Post> postList) {
        inflater = activity.getLayoutInflater();
        this.postList = postList;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;

        rowView = inflater.inflate(R.layout.row, parent, false);

        EditText txtMessage = rowView.findViewById(R.id.txtMessage);
        TextView txtLocation = rowView.findViewById(R.id.textLocation);
        ImageView imgView = rowView.findViewById(R.id.imgProfilePic);

        Post post = postList.get(position);
        txtMessage.setText(post.getMessage());
        imgView.setImageBitmap(post.getImage());

        if (post.getLocation() != null) {
            txtLocation.setText(post.getLocation().getLatitude()
                    + " " + post.getLocation().getLongitude());
        }

        return rowView;
    }
}