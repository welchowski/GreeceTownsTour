package com.example.lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class TowAdapter extends ArrayAdapter<Towns> {
    private LayoutInflater inflater;
    private int layout;
    private List<Towns> towns;
    String klkday = "Кільк. днів: ";
    String vartist = "Вартість: ";
    String grn = " грн";
    String doba = "Доба:";

    public TowAdapter(@NonNull Context context, int resource, List<Towns> towns) {
        super(context, resource, towns);
        this.towns = towns;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Towns product = towns.get(position);

        viewHolder.nameView.setText(product.getName());
        viewHolder.textday.setText(doba + Integer.toString(product.getPriceforday()));
        viewHolder.iimageView.setImageResource(product.getImg());
        viewHolder.countView.setText(format(product.getCount(), klkday));

        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = product.getCount() - 1;
                if (count < 0) count = 0;
                product.setCount(count);
                product.setPricetotal(count * product.getPriceforday());
                viewHolder.countView.setText(format(count, klkday));
                viewHolder.price.setText(vartist + format(product.getCount() * product.priceforday) + grn);

            }
        });

        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = product.getCount() + 1;
                product.setCount(count);
                product.setPricetotal(count * product.getPriceforday());
                viewHolder.price.setText(vartist + format(product.getCount() * product.priceforday) + grn);
                viewHolder.countView.setText(format(count, klkday));
            }
        });
        return convertView;
    }

    private String format(int count, String name) {
        return name + String.valueOf(count);
    }

    private String format(int count) {
        return String.valueOf(count);
    }

    private class ViewHolder {
        final Button addButton, removeButton;
        final TextView nameView, countView, textday, price;
        final ImageView iimageView;

        ViewHolder(View view) {
            addButton = view.findViewById(R.id.button_plus);
            removeButton = view.findViewById(R.id.button_minus);
            textday = view.findViewById(R.id.text_day);
            iimageView = view.findViewById(R.id.imageView);
            nameView = view.findViewById(R.id.textView);
            countView = view.findViewById(R.id.textView4);
            price = view.findViewById(R.id.textView6);
        }
    }
}

