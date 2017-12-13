package cn.compal.feeling.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wolf on 2017/11/7.
 */

public class MvvmCommonAdapter extends RecyclerView.Adapter<MvvmCommonAdapter.CommonHolder>
{

    protected Context mContext;
    //所有 item 的数据集合
    protected List mDatas;
    //item 布局文件 id
    protected int mLayoutId;
    protected LayoutInflater mInflater;
    // mvvm绑定的viewModel引用
    private int mVariableId;

    private OnItemClickListener mOnItemClickListener;
    //构造方法
    public MvvmCommonAdapter(List datas, int variableId, Context context, int layoutId)
    {
        mContext = context;
        mDatas = datas;
        mLayoutId = layoutId;
        mInflater = LayoutInflater.from(mContext);
        mVariableId = variableId;
    }


    public List getmDatas()
    {
        return mDatas;
    }

    public void setmDatas(List mDatas)
    {
        this.mDatas = mDatas;
    }

    @Override
    public CommonHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), mLayoutId, parent, false);
        CommonHolder myHolder = new CommonHolder(binding.getRoot());
        myHolder.setBinding(binding);
        myHolder.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(@NonNull View view, int adapterPosition)
            {
                if (mOnItemClickListener != null)
                {
                    mOnItemClickListener.onItemClick(view, adapterPosition);
                }
            }
        });

        return myHolder;
    }

    @Override
    public void onBindViewHolder(CommonHolder holder, int position)
    {
        holder.binding.setVariable(mVariableId, mDatas.get(position));
        holder.binding.executePendingBindings();
    }
    public void setOnItemClickListener(@Nullable OnItemClickListener onItemClickListener)
    {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount()
    {
        return null == mDatas ? 0 : mDatas.size();
    }


    class CommonHolder extends RecyclerView.ViewHolder
    {
        private ViewDataBinding binding;

        public CommonHolder(View itemView)
        {
            super(itemView);
        }

        public ViewDataBinding getBinding()
        {
            return binding;
        }

        public void setBinding(ViewDataBinding binding)
        {
            this.binding = binding;
        }

        private OnItemClickListener mOnItemClickListener;

        private final View.OnClickListener mOnClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mOnItemClickListener != null)
                {
                    mOnItemClickListener.onItemClick(v, getAdapterPosition());
                }
            }
        };

        void setOnItemClickListener(OnItemClickListener onItemClickListener)
        {
            this.mOnItemClickListener = onItemClickListener;

            if (onItemClickListener != null)
            {
                this.itemView.setOnClickListener(mOnClickListener);
            }
        }
    }

}
