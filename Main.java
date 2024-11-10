import java.util.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.regex.*;
import java.lang.String;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);        

        System.out.println("Box size value should be less than 10.......");
        System.out.println("Enter the box size....");
        // int input=Integer.parseInt(JOptionPane.showInputDialog("Enter the size of the\"Box\"(6X6 || 9X9) : "));
        int input = sc.nextInt();
        int two=2,row=0,col=0;
        boolean bh=true;
        if(input>100)
        {
            System.out.println("Box size value should be less than 10.......");
        }
        else
        {
            if(input==1)
            {
                row=1;
                col=1;
            }
            else
            {
              while(bh)
              {
                  if(input%two==0)
                  {
                      row=two;
                      col=input/two;
                      bh=false;
                  }
                  else
                  two++;
              }
            }
            Print.print(sc,input,row,col);
        }
    }
}


// 0 0 0 0 0 0
class Replace_arr
{
    public static void replace_arr(ArrayList<ArrayList<Integer>> arr,ArrayList<Integer> arr_col,int input)
    {
        for(int i=0;i<input;i++)
        {
            arr_col=new ArrayList<Integer>();
            for(int j=0;j<input;j++)
            {
                arr_col.add(j,0);
            }
            arr.add(i, arr_col);
        }
    }
}


class Regex
{
    public static int Check_regex1(String User_input)
    {
        int c=0;
        Pattern p = Pattern.compile("\\W");
        Matcher m=p.matcher(User_input);
        while(m.find())
        {
            c++;
            break;
        }
        return c;
    }
    public static int Check_regex2(String User_input)
    {
        int c=0;
        String str="";
        str=str+User_input.charAt(1);
        Pattern p = Pattern.compile("\\d");
        Matcher m=p.matcher(str);
        while(m.find())
        {
            c++;
            break;
        }
        return c;
    }
}


// Printing Box
class Box
{
    public static void box(ArrayList<String> ROW,ArrayList<String> COL,ArrayList<String> DUP,int row,int col)
    {
         //Printing Box
        int count=0;
        int zero=0,pk=0;
        int dul=2;
        int Side_Num=1;
       
        for(int i=0;i<((row*3)+row+1)*col;i++)
        {
            if(i==zero)
            {
                count++;
                System.out.print(ROW.get(0));

                if(count==row+1)
                {
                    count=0;
                    zero++;
                    dul++;
                }
                else
                {
                    zero=zero+4;
                }
            }
            else
            {
                    if(i==dul)
                    {
                        System.out.print(COL.get(pk++));
                        System.out.print(" "+Side_Num++);
                        dul+=4;
                    }
                    else
                    {
                        DUP.forEach(n->System.out.print(n));
                    }
            }
            System.out.println();
        }
    }
}


class Col_Array
{
    public static void alter(ArrayList<ArrayList<Integer>> arr,ArrayList<String> COL,int row,int col)
    {
    for(int i=0;i<arr.size();i++)
        {
            int a=0;
            String str="";
            for(int k=0;k<row;k++)
            {
                ArrayList<String> dup=new ArrayList<>();
                for(int l=0;l<col+1;l++)
                {
                    if(l==col)
                        dup.add(l,"|");
                    else if(arr.get(i).get(a)==null || arr.get(i).get(a)==0)
                    {
                        dup.add(l,"|   ");
                        a++;
                    }
                    else
                    {
                        dup.add(l,"| "+arr.get(i).get(a)+" ");
                        a++;
                    }
                    }
                    // System.out.println(COL.get(0));
                    for(int m=0;m<dup.size();m++)
                        str=str+dup.get(m);
                    dup.clear();
                }
                COL.add(i,str);
        }
       }

       public static void alter1(ArrayList<String> DUP,int row,int col)
       {
        String str="";
        for(int j=0;j<col+1;j++)
            {
                if(j==col)
                    str=str+"|";
                else
                    str=str+"|   ";
            }
            for(int i=0;i<row;i++)
                DUP.add(str);
            // DUP.add(0,str);
       }
}


class Row_Array
{
    public static void alter(ArrayList<String> ROW,int col,int row)
    {
        ArrayList<String> FIN=new ArrayList<>();
        String str="";
            for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                {
                    if(j==col-1)
                    FIN.add(" --- ");
                    else
                    FIN.add(" ---");
                }
                // ROW.forEach(n->System.out.print(n));
                for(int k=0;k<col;k++)
                    str=str+FIN.get(k);
                FIN.clear();
            }
            ROW.add(str);
    }
}


// A B C D
class Alpha
{
    public static String abc="";
    public static void alpha(int input,int row,int col)
    {
        ArrayList<String> ch=new ArrayList<>();
        
        // for printing A B C D E
        char A='A';
        abc=abc+A;
        ch.add("  "+A++);
        if(row==input)
        {
            for(int i=1;i<input;i++)
            {
                abc=abc+A;
                ch.add("    "+A++);
            }
        }
        else
        {
            int v=col-1;
            for(int i=1;i<input;i++)
            {
                abc=abc+A;
                if(i==v)
                {
                  ch.add("   "+A+++" ");
                  v+=col;
                }
                else
                  ch.add("   "+A++);
            }
        }
 
        // System.out.println(abc);
        ch.forEach(n->System.out.print(n));
        System.out.println();
    }
}


// Odd
class Print
{
    public static void print(Scanner sc,int input,int row,int col)
    {
        System.out.println();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr_col=new ArrayList<Integer>();

        ArrayList<String> DUP=new ArrayList<String>();

        //For add 0 0 0 0   
        Replace_arr.replace_arr(arr,arr_col,input);

        ArrayList<String> ROW=new ArrayList<String>();
        ArrayList<String> COL=new ArrayList<String>();
        
        
        // System.out.println("Row :"+row);
        // System.out.println("Col :"+col);

        // for create arraylist for ---
        Row_Array.alter(ROW,col,row);
        // for create arraylist for ||
        Col_Array.alter(arr,COL,row,col);

        Col_Array.alter1(DUP,row,col);

        //A B C D...
        Alpha.alpha(input,row,col);
        // Box 
        Box.box(ROW,COL,DUP,row,col);
        
        String User_input;
        int value;
        boolean bh=true;

        while(bh)
        {
            System.out.println("Enter the Position : \t \t If inputs are completed type \"solve\" and hit ENTER to get the answer");
            User_input=sc.next();
            if(User_input.equals("SOLVE") || User_input.equals("solve"))
            {
                bh=false;
                System.out.println("\t\tAnswer\t\t");
            }
            else
            {
                User_input=User_input.toUpperCase();

                int count_check1=Regex.Check_regex1(User_input);
                int count_check2=Regex.Check_regex2(User_input);
                
                if(User_input.length()>2)
                {
                    System.out.println("Please enter the valid Position.....!");
                }
                else if(count_check1>0)
                {
                    System.out.println("Don't use special(@ # $ %....) characters...!");
                }
                else if(count_check2>0)
                {
                    System.out.println("Don't use numbers instead of using A B C D.. or a b c..");
                }
                else
                {
                    System.out.println("Enter the Value");
                    value=sc.nextInt();
                    if(value==0)
                    System.out.println("Don't enter zero....!");
                    else if(value > input)
                    {
                      System.out.println("The value must be less than Box size...!");
                    }
                    else
                    {
                        int pos=Character.getNumericValue(User_input.charAt(0))-1;
                        int pos1=0;

                        for(int z=0;z<input;z++)
                        {
                            if(User_input.charAt(1)==(Alpha.abc).charAt(z))
                            {
                                pos1=pos1+z;
                                break;
                            }
                        }

                        // System.out.println("pos :"+pos);
                        // System.out.println("Pos1 :"+pos1);
                    
                          arr.get(pos).set(pos1, value);
                          Col_Array.alter(arr,COL,row,col);
                          Alpha.alpha(input, row, col);
                          Box.box(ROW,COL,DUP,row,col);
                    }
                }
            }    
        }
        if(input==row)
        {
            Odd obj=new Odd(input);
            obj.odd(DUP, ROW, COL, arr, row, col);
        }
        else
        {
            
        }
    }
}

class Check_Duplicate
{
    public static int duplicate(ArrayList<ArrayList<Integer>> arr,int c,int times)
    {
        for(int i=0;i<arr.size();i++)
        {
            for(int j=0;j<arr.get(i).size()-1;j++)
            {
                for(int k=j+1;k<arr.get(i).size();k++)
                {
                    if(times==1)
                    {
                        if((arr.get(i).get(j)==arr.get(i).get(k)) && (arr.get(i).get(j)!=0 && arr.get(i).get(k)!=0))
                        {
                            c++;
                            break;
                        }
                    }
                    if(times==2)
                    {
                        if((arr.get(j).get(i)==arr.get(k).get(i)) && (arr.get(j).get(i)!=0 && arr.get(k).get(i)!=0))
                        {
                            c++;
                            break;
                        }
                    }
                }
            }
        }
        return c;
    }
}


class Even
{
    
    static int INPUT;
    public Even(int input)
    {
        INPUT = input;
    }
    
    
    public static void even(ArrayList<String> DUP,ArrayList<String> ROW,ArrayList<String> COL,ArrayList<ArrayList<Integer>> arr,int row,int col)
    {
        
    }
}


class Odd
{
    static int INPUT;
    public Odd(int input)
    {
        INPUT = input;
    }
    static int kumar=0;
    static int hi=0;
    
    public static void odd(ArrayList<String> DUP,ArrayList<String> ROW,ArrayList<String> COL,ArrayList<ArrayList<Integer>> arr,int row,int col)
    {
        ArrayList<Integer> add_values=new ArrayList<>();
        ArrayList<Integer> dummy=new ArrayList<>();
        ArrayList<ArrayList<Integer>> arr1=new ArrayList<ArrayList<Integer>>();

        int c=0;
        c=Check_Duplicate.duplicate(arr,c,1);
        c=Check_Duplicate.duplicate(arr,c,2);
        if(c>=1)
        {
            System.out.println("Don't enter the same numbers on same ROW or same COLUMN....!");
        }
        else
        {
            boolean bh=true;
            int ak=0;
            while(bh)
            {
                bh=Odd.Fixed_Value(arr,add_values,dummy);
                Odd.Set(arr1, arr);
                if(hi==0)
                {
                    Odd.Remain(arr,arr1,add_values,ak,dummy);
                    if(ak<Odd.INPUT-1)
                    {
                        ak++;
                    }
                }
                if(Odd.Zero(arr))
                {
                    bh=false;
                }
                hi=0;
            }
             Col_Array.alter(arr,COL,row,col);
             Alpha.alpha(Odd.INPUT, row, col);
             Box.box(ROW,COL,DUP,row,col);
        }
    }
    
    public static void Set(ArrayList<ArrayList<Integer>> arr,ArrayList<ArrayList<Integer>> arr1)
    {
        arr.clear();
        for(int i=0;i<Odd.INPUT;i++)
        {
            ArrayList<Integer> pk=new ArrayList<>();
            for(int j=0;j<Odd.INPUT;j++)
            {
               pk.add(arr1.get(i).get(j));
            }
            arr.add(pk);
        }
    }


    public static void Remain(ArrayList<ArrayList<Integer>> arr,ArrayList<ArrayList<Integer>> arr1,ArrayList<Integer> add_values,int ak,ArrayList<Integer> dummy)
    {
        boolean bala=true;
        int one=1;
        int Max_Value=Odd.INPUT;

        for(int j=0;j<Odd.INPUT;j++)
        {
            if(arr.get(ak).get(j)==0)
            {
                if(bala)
                {
                    if(one>Odd.INPUT)
                    {
                        j=-1;
                       Odd.Set(arr, arr1);
                        bala=false;
                        one=1;
                        Max_Value=Odd.INPUT;
                    }
                    else
                    {
                        Add_Values(arr, add_values, ak, j);
                        if(add_values.contains(one))
                        {
                            one++;
                            j--;
                        }
                        else
                        {
                            arr.get(ak).set(j, one);
                            Odd.Fixed_Value(arr,add_values,dummy);
                            one=1;
                        }
                    }
                }
                else
                {
                    Add_Values(arr, add_values, ak, j);
                    if(add_values.contains(Max_Value))
                    {
                        Max_Value--;
                        j--;
                    }
                    else
                    {
                        arr.get(ak).set(j, Max_Value);
                        Odd.Fixed_Value(arr,add_values,dummy);
                        Max_Value=Odd.INPUT;
                    }
                }
            }
        }
    }


    public static boolean Fixed_Value(ArrayList<ArrayList<Integer>> arr,ArrayList<Integer> add_values,ArrayList<Integer> dummy)
    {
        kumar++;
        boolean bh=false;
        // int sri=0;
        for(int i=0;i<Odd.INPUT;i++)
        {
            for(int j=0;j<Odd.INPUT;j++)
            {
                if(arr.get(i).get(j)==0)
                {
                    Odd.Add_Values(arr,add_values,i,j);
                    Odd.Dummy(dummy);
                    dummy.removeAll(add_values);

                    bh=Odd.Check(arr,dummy,i,j);
                }
                if(bh && kumar==1)
                {
                    System.out.println("Enter the values in correct format....\n\n");
                    break;
                }
                // if(sri!=0)
                // {
                //     break;
                // }
            }
            if(bh && kumar==1)
            {
                return false;
            }
            // if(sri!=0)
            // {
            //     break;
            // }
        }
        return true;
    }

    public static boolean Check(ArrayList<ArrayList<Integer>> arr,ArrayList<Integer> dummy,int i,int j)
    {
        if(dummy.size()==0)
        {
            return true;
        }
        else if(dummy.size()==1)
        {
            arr.get(i).set(j,dummy.get(0));
            hi++;
            // sri++;
        }
        else
        {
            for(int a=0;a<dummy.size();a++)
            {
                Row_Col(arr, dummy, a, i, j);
            }
        }
        return false;
    }

     public static void Row_Col(ArrayList<ArrayList<Integer>> arr,ArrayList<Integer> dummy,int a,int i,int j)
    {
        ArrayList<Integer> pk=new ArrayList<Integer>();
        for(int x=0;x<Odd.INPUT;x++)
        {
            if(arr.get(x).get(j)==0)
            {
                if(arr.get(x).contains(dummy.get(a)))
                    continue;
                else
                    pk.add(x);
            }
        }

        if(pk.size()==1)
        {
            arr.get(pk.get(0)).set(j, dummy.get(a));
            hi++;
            // sri++;
        }
        
        pk.clear();

        for(int x=0;x<Odd.INPUT;x++)
        {
            if(arr.get(i).get(x)==0)
            {
                ArrayList<Integer> pk1=new ArrayList<>();
                for(int z=0;z<Odd.INPUT;z++)
                {
                    pk1.add(arr.get(z).get(j));
                }
                if(pk1.contains(dummy.get(a)))
                    continue;
                else
                    pk.add(x);
            }
        }

        if(pk.size()==1)
        {
            arr.get(i).set(pk.get(0),dummy.get(a));/////doubt.....
            hi++;
            // sri++;
        }
    }

    public static void Add_Values(ArrayList<ArrayList<Integer>> arr,ArrayList<Integer> add_values,int i,int j)
    {
        add_values.clear();
            for(int a=0;a<Odd.INPUT;a++)
            {
                if(arr.get(i).get(a)!=0)
                    add_values.add(arr.get(i).get(a));
                if(arr.get(a).get(j)!=0)
                    add_values.add(arr.get(a).get(j));
            }
    }

    public static void Dummy(ArrayList<Integer> dummy)
    {
        dummy.clear();
        for(int i=1;i<=Odd.INPUT;i++)
        {
            dummy.add(i);
        }
    }

    public static boolean Zero(ArrayList<ArrayList<Integer>> arr)
    {
        int count=0;
        for(int i=0;i<Odd.INPUT;i++)
        {
            ArrayList<Integer> arr1=new ArrayList<>();
            
            for(int j=0;j<Odd.INPUT;j++)
            {
                if(arr.get(i).get(j)!=0)
                {
                    arr1.add(arr.get(i).get(j));
                }
            }
            if(arr1.size()==Odd.INPUT)
            {
                count++;
            }

            arr1.clear();

            for(int j=0;j<Odd.INPUT;j++)
            {
                if(arr.get(j).get(i)!=0)
                {
                    arr1.add(arr.get(j).get(i));
                }
            }
            if(arr1.size()==Odd.INPUT)
            {
                count++;
            }
        }
        if(count==Odd.INPUT*2)
        {
            return true;
        }
        return false;
    }
}