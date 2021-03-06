package tickspot.application.sev.tickspot.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tickspot.application.sev.tickspot.R;
import tickspot.application.sev.tickspot.model.Preset;

/**
 * Created by Sev on 07/02/15.
 */
public class PresetSpinnerAdapter extends ArrayAdapter {
    private List<Preset> presets;

    public PresetSpinnerAdapter(Context context, List<Preset> presets) {
        super(context, 0, presets);
        this.presets = presets;
    }

    @Override
    public int getCount() {
        return presets.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_row, parent, false);
        TextView label = (TextView) row.findViewById(R.id.spinner_text);
        label.setText(String.valueOf(presets.get(position).getFormattedPreset()));
        return row;
    }
}
