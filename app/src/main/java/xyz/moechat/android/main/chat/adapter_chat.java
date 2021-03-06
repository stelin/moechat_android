package xyz.moechat.android.main.chat;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import xyz.moechat.android.R;

/**
 * Created by timeloveboy on 16/4/10.
 */
public class adapter_chat extends BaseAdapter{
    private Fragment fromFragment;
    private List<Mson_chatlistitem> list;

    public adapter_chat(Fragment fromFragment, List<Mson_chatlistitem> list) {
        this.fromFragment = fromFragment;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list != null ? list .size() : 0;
    }

    @Override
    public Object getItem(int position) {
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(fromFragment.getActivity()).inflate(R.layout.item_linearlayout_chat, parent, false);
            findviewById(holder,convertView);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        //设置内容
        holder.textView_linearlayout_item_chat.setText(list.get(position).lastunreadmessagecontent());
        holder.textView_item_chat_fromid.setText(list.get(position).fromid());
        holder.textView_item_chat_unreadmessagecount.setText(list.get(position).unreadmessagecount()+"");
        holder.textView_item_chat_lastreceivetime.setText(list.get(position).lastunreadmessagetime());
        return convertView;
    }
    private void findviewById(ViewHolder holder,View view){
        holder.textView_linearlayout_item_chat=(TextView)view.findViewById(R.id.textView_item_chat_content);
        holder.textView_item_chat_fromid=(TextView)view.findViewById(R.id.textView_item_chat_fromid);
        holder.textView_item_chat_unreadmessagecount=(TextView)view.findViewById(R.id.textView_item_chat_unreadmsgcount);
        holder.textView_item_chat_lastreceivetime=(TextView)view.findViewById(R.id.textView_item_chat_lastreceivetime);
    }
    private static class ViewHolder {
        private TextView textView_linearlayout_item_chat,textView_item_chat_fromid,textView_item_chat_unreadmessagecount,textView_item_chat_lastreceivetime;
    }
}
