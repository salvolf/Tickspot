package tickspot.application.sev.tickspot.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tickspot.application.sev.tickspot.R;
import tickspot.application.sev.tickspot.restservice.models.Task;

/**
 * Created by Sev on 07/02/15.
 */
public class TasksSpinnerAdapter extends ArrayAdapter {
    private List<Task> spinnerElement;
    private boolean hasItemSelected = false;

    public TasksSpinnerAdapter(Context context, int resource, List<Task> objects) {
        super(context, resource, objects);
        spinnerElement = objects;
    }

    @Override
    public int getCount() {
        return spinnerElement.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_row, parent, false);
        TextView label = (TextView) row.findViewById(R.id.spinner_text);
        label.setText(String.valueOf(spinnerElement.get(position).name));
        return row;
    }

    public boolean hasItemSelected() {
        return hasItemSelected;
    }

    public void setHasItemSelected(boolean hasItemSelected) {
        this.hasItemSelected = hasItemSelected;
    }
}