package com.khierblogger.khierbloggerapp.Activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khierblogger.khierbloggerapp.MainClasses.Organization;
import com.khierblogger.khierbloggerapp.R;

import java.util.ArrayList;
import java.util.List;

public class OrganizationListAdapter extends RecyclerView.Adapter<OrganizationListAdapter.OrganizationViewHolder>{

    private List<Organization> organizations ;

    public OrganizationListAdapter(List<Organization> organizations){
        this.organizations = organizations;
    }

    @Override
    public OrganizationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrganizationViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.organization_view , parent));
    }

    @Override
    public void onBindViewHolder(OrganizationViewHolder holder, int position) {
        Organization organization = organizations.get(position);
        holder.organizationName.setText(organization.getName());
        holder.organizationSlogan.setText(organization.getSlogan());
    }

    @Override
    public int getItemCount() {
        return organizations.size();
    }

    protected static class OrganizationViewHolder extends RecyclerView.ViewHolder{

        ImageView organizationImageView ;
        TextView organizationName ;
        TextView organizationSlogan ;

        public OrganizationViewHolder(View itemView) {
            super(itemView);
            organizationImageView = (ImageView) itemView.findViewById(R.id.organization_image);
            organizationName = (TextView) itemView.findViewById(R.id.organization_name);
            organizationSlogan = (TextView) itemView.findViewById(R.id.organization_slogan);
        }
    }
}
