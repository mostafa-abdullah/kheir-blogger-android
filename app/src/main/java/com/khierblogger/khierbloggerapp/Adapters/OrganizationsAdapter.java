package com.khierblogger.khierbloggerapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khierblogger.khierbloggerapp.Intefaces.OrganizationCallbacks.OrganizationClickedCallback;
import com.khierblogger.khierbloggerapp.MainClasses.Organization;
import com.khierblogger.khierbloggerapp.R;

import java.util.List;

public class OrganizationsAdapter extends RecyclerView.Adapter<OrganizationsAdapter.OrganizationViewHolder>{

    private List<Organization> organizations ;
    private OrganizationClickedCallback callback;

    public OrganizationsAdapter(List<Organization> organizations , OrganizationClickedCallback callback){
        this.organizations = organizations;
        this.callback = callback;
    }

    @Override
    public OrganizationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrganizationViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.organization_view , parent , false));
    }

    @Override
    public void onBindViewHolder(final OrganizationViewHolder holder, int position) {
        holder.organizationImageView.setImageResource(position%2 == 0? R.drawable.google : R.drawable.instagram);
        final Organization organization = organizations.get(position);
        holder.organizationName.setText(organization.getName());
        holder.organizationSlogan.setText(organization.getSlogan());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onOrganizationClicked(organization, holder.organizationImageView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return organizations.size();
    }

    protected static class OrganizationViewHolder extends RecyclerView.ViewHolder{

        ImageView organizationImageView ;
        TextView organizationName ;
        TextView organizationSlogan ;
        ViewGroup parentLayout ;

        public OrganizationViewHolder(View itemView) {
            super(itemView);
            organizationImageView = (ImageView) itemView.findViewById(R.id.organization_image);
            organizationName = (TextView) itemView.findViewById(R.id.organization_name);
            organizationSlogan = (TextView) itemView.findViewById(R.id.organization_slogan);
            parentLayout = (ViewGroup) itemView.findViewById(R.id.parent_layout);
        }
    }
}
