package cn.compal.feeling.test;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import cn.compal.feeling.R;


/**
 * Created by wolf on 2017/11/17.
 */

public class InstructionBooksBean extends BaseObservable
{

    @SerializedName("moduleThreeXIconUrl")
    public String moduleThreeXIconUrl;
    @SerializedName("instructionBooksUrl")
    public String instructionBooksUrl;
    @SerializedName("sysModuleName")
    public String sysModuleName;
    @SerializedName("sysModuleId")
    public String sysModuleId;
    @SerializedName("moduleTwoXIconUrl")
    public String moduleTwoXIconUrl;

    private static String picBaseUrl = "http://css.telecomjs.com";

    public InstructionBooksBean()
    {
        this.moduleThreeXIconUrl = "";
        this.instructionBooksUrl = "";
        this.sysModuleName = "";
        this.sysModuleId = "";
        this.moduleTwoXIconUrl = "";
    }

    public String getModuleThreeXIconUrl()
    {
        return moduleThreeXIconUrl;
    }

    public void setModuleThreeXIconUrl(String moduleThreeXIconUrl)
    {
        this.moduleThreeXIconUrl = moduleThreeXIconUrl;
    }

    public String getInstructionBooksUrl()
    {
        return instructionBooksUrl;
    }

    public void setInstructionBooksUrl(String instructionBooksUrl)
    {
        this.instructionBooksUrl = instructionBooksUrl;
    }

    public String getSysModuleName()
    {
        return sysModuleName;
    }

    public void setSysModuleName(String sysModuleName)
    {
        this.sysModuleName = sysModuleName;
    }

    public String getSysModuleId()
    {
        return sysModuleId;
    }

    public void setSysModuleId(String sysModuleId)
    {
        this.sysModuleId = sysModuleId;
    }

    public String getModuleTwoXIconUrl()
    {
        return moduleTwoXIconUrl;
    }

    public void setModuleTwoXIconUrl(String moduleTwoXIconUrl)
    {
        this.moduleTwoXIconUrl = moduleTwoXIconUrl;
    }

    @BindingAdapter("bind:imgFromUrl")
    public static void getImgFromUrl(ImageView iv, String url)
    {
        Picasso.with(iv.getContext()).load(picBaseUrl + url).into(iv);
    }
}
