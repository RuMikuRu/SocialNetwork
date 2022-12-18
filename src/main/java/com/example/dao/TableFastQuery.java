package com.example.dao;

public class TableFastQuery {
    public static String getALL(String nameTable, String col1, String col2, String col3,String col4)
    {
        return "SELECT "+col1+","+col2+","+col3+","+col4+" FROM "+nameTable;
    }
    public static String getALL(String nameTable, String col1, String col2, String col3)
    {
        return "SELECT "+col1+","+col2+","+col3+","+" FROM "+nameTable;
    }

    public static String getFromKey(String nameTable, String tableKey, String key)
    {
        return "SELECT * FROM "+nameTable+" where "+tableKey+"="+key;
    }

    public static String addData(String nameTable, String col1, String col2, String col3,String col4,
                                 int par1,String par2,String par3, String par4)
    {
        return "insert into "+nameTable+" ("+col1+","+col2+","+col3+","+col4+") values ("+par1+","+"'"+par2+"','"+par3+"','"+par4+"')ON CONFLICT DO NOTHING;";
    }
    public static String addData(String nameTable, String col1, String col2, String col3,
                                 int par1,String par2,String par3)
    {
        return "insert into "+nameTable+" ("+col1+","+col2+","+col3+") values ("+par1+","+"'"+par2+"','"+par3+"')ON CONFLICT DO NOTHING;";
    }

    public static String updateData(String nameTable,String col1, String col2, String col3,
                                    String par1,String par2,String par3, String key,int keyValue)
    {
        return "update "+nameTable+" set " + col1 + "='" +par1 +"', "+col2 +"='"+par2+"', "+col3+"='"+par3+"' where "+key + "="+keyValue;
    }
    public static String updateData(String nameTable,String col1, String col2,
                                    String par1,String par2, String key,int keyValue)
    {
        return "update "+nameTable+" set " + col1 + "='" +par1 +"', "+col2 +"='"+par2+"' where "+key + "="+keyValue;
    }
}
