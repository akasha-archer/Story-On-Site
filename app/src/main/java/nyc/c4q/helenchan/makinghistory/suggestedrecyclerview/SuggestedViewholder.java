package nyc.c4q.helenchan.makinghistory.suggestedrecyclerview;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import nyc.c4q.helenchan.makinghistory.R;
import nyc.c4q.helenchan.makinghistory.ViewContentActivity;
import nyc.c4q.helenchan.makinghistory.suggestedrecyclerview.models.SuggestedItem;

/**
 * Created by leighdouglas on 3/12/17.
 */

public class SuggestedViewholder extends RecyclerView.ViewHolder {
    private ImageView sggstdBttn;
    private TextView sggstdTitle;

    public SuggestedViewholder(View itemView) {
        super(itemView);
        sggstdBttn = (ImageView) itemView.findViewById(R.id.suggested_image);
        sggstdTitle = (TextView) itemView.findViewById(R.id.suggested_title);
        Typeface arimaMadurai = Typeface.createFromAsset(itemView.getContext().getApplicationContext().getAssets(), "ArimaMadurai-Regular.ttf");
        sggstdTitle.setTypeface(arimaMadurai);


    }

    public void bind(SuggestedItem suggestedItem) {
        sggstdBttn.setImageResource(suggestedItem.getDrawable());
        sggstdBttn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        sggstdTitle.setText(suggestedItem.getCity());

    }

    public void initViews() {

    }
}
