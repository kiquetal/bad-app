package cresterida.me.learning.fireappdemo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.zakariya.stickyheaders.SectioningAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kiquetal on 8/7/17.
 */

public class AdapterFire extends org.zakariya.stickyheaders.SectioningAdapter{


    Map<String,List<Codes>> codesFires=new HashMap<>();

    List<Map<String,List<Codes>>>sections=new ArrayList<>();

    List<String> namesSection=Arrays.asList("INFORMACIÓN DE APOYO","SITUACIÓN DE EMERGENCIA","INFORMACIÓN DE SERVICIO","INFORMACIONES NECESARIAS");
    private boolean USE_DEBUG_APPEARANCE=true;

    public AdapterFire()
    {

        codesFires.put("INFORMACIÓN DE APOYO", Arrays.asList(new Codes("10.80","ANDE"),new Codes("10.81","ESSAP")));
        codesFires.put("SITUACIÓN DE EMERGENCIA", Arrays.asList(new Codes("10.70","Urgente. Sin demora"),new Codes("10.71","Sin urgencia. Normal"),new Codes("10.72","Pequeña magnitud"),new Codes("10.73","Mediana Magnitud")));
        codesFires.put("INFORMACIÓN DE SERVICIO", Arrays.asList(new Codes("10.40","Incendio especificar"),new Codes("10.41","Accidente especificar"),new Codes("10.42","Persona atrapada en ")));
        codesFires.put("INFORMACIONES NECESARIAS",Arrays.asList(new Codes("10.00","Identifíquese [nombre o código]"),new Codes("10.01","Interferencia")));
    }

private class Codes{
    private String code;
    private String name;

    Codes(String code,String name)
    {
        this.code=code;
        this.name=name;
    }
}



    public void loadList() {
         sections.clear();

        int ind=0;
        for (String in: namesSection)
        {
         Map<String,List<Codes>> mp=new HashMap<>();
            mp.put(in,codesFires.get(in));
            sections.add(mp);
        }

        notifyAllSectionsDataSetChanged();
    }



    public class ItemViewHolder extends SectioningAdapter.ItemViewHolder {
        TextView personNameTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            personNameTextView = (TextView) itemView.findViewById(R.id.personNameTextView);
        }
    }

    public class HeaderViewHolder extends SectioningAdapter.HeaderViewHolder {
        TextView titleTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
        }
    }




    @Override
    public int getNumberOfSections() {
        return sections.size();
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {
        Map<String,List<Codes>> mp=sections.get(sectionIndex);
        return mp.get(namesSection.get(sectionIndex)).size();
    }

    @Override
    public boolean doesSectionHaveHeader(int sectionIndex) {
        return true;
    }

    @Override
    public boolean doesSectionHaveFooter(int sectionIndex) {
        return false;
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_item_addressbook_person, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_item_addressbook_header, parent, false);
        return new HeaderViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int sectionIndex, int itemIndex, int itemType) {
        Map<String,List<Codes>> s = sections.get(sectionIndex);
        ItemViewHolder ivh = (ItemViewHolder) viewHolder;
        Codes codes = s.get(namesSection.get(sectionIndex)).get(itemIndex);
        ivh.personNameTextView.setText(codes.code+ "-"+codes.name);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int sectionIndex, int headerType) {
        Map<String,List<Codes>> s = sections.get(sectionIndex);
        HeaderViewHolder hvh = (HeaderViewHolder) viewHolder;

        if (USE_DEBUG_APPEARANCE) {
            hvh.itemView.setBackgroundColor(0x55ffffff);
            hvh.titleTextView.setText(pad(sectionIndex * 2)+namesSection.get(sectionIndex));
        } else {
            hvh.titleTextView.setText(namesSection.get(sectionIndex));
        }
    }

    private String pad(int spaces) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            b.append(' ');
        }
        return b.toString();
    }


}
