package P1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MagicSquare {

	public static boolean isInt(String str){  
		  for (int i = str.length();--i>=0;){    
		   if (!Character.isDigit(str.charAt(i))){  
		    return false;  
		   }  
		  }  
		  return true;  
		}  
	public static boolean isLegalMagic(String fileName) {
		FileReader file = null;
		BufferedReader br = null;
		try {
			file = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		br = new BufferedReader(file);
		try {
			String line = br.readLine();// 按行读取
			if(line.contains(" "))
			{
				
					System.out.print("间隔不是制表符");
					return false;
				}
			String[] sp = null;
			sp = line.split("\t");
			int lines = sp.length;// 将每一行转换成整数
			int[][] cc = new int[lines][lines];
			for(int m = 0;m<lines;m++)
			{
				if(isInt(sp[m]))
				{
					cc[0][m] = Integer.valueOf(sp[m]);
				}
				
				else
					
					{
					System.out.print("数字类型不正确");
					return false;
					}
					
			}
			int count = 1;
			while ((line = br.readLine()) != null) {
				sp = line.split("\t");
				int line0 = sp.length;
				if(line.contains(" "))
				{
					
						System.out.print("间隔不是制表符");
						return false;
					}
				
				if(line0!=lines)//个数不一样，不是方阵
					{
					System.out.print("非方阵");
					return false;
					}
				for (int i = 0; i < line0; i++) {
					if(isInt(sp[i]))
					{
						cc[count][i] = Integer.valueOf(sp[i]);
					}
					else
						{
						System.out.print("数字类型不正确");
						return false;
						}
					
				}
				count++;
			}
			
			int sum0 = 0;
			
			for(int n = 0;n<sp.length;n++) {
				sum0 = sum0 + cc[n][n];
				
			} // 计算对角线上的和作为检验标准
			int sum = 0;
			for (int m = 0; m < sp.length; m++) {
				for (int n1 = 0; n1 < sp.length; n1++) {
					sum = sum + cc[m][n1];
				}
				if (sum != sum0)
					{
					System.out.print("计算结果不相同");
					return false;
					}
				else
					sum = 0;
			}
			if(count!=sp.length)
			{
				System.out.println("非方阵 ");
				return false;
			}
			return true;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean generateMagicSquare(int n) {//赋值范围为1~n*n
        if(n%2 == 0||n<0) {
        	return false;
        }
		int magic[][] = new int[n][n];// 建立一个n维数组
		int row = 0, col = n / 2, i, j, square = n * n;
		for (i = 1; i <= square; i++) {
			magic[row][col] = i;
			if (i % n == 0)// 若赋值数字是n的倍数
				row++;
			else {// 如果不是n的倍数
				if (row == 0)// 如果是第一行的话
					row = n - 1;// 将行数调整为最后一行
				else
					row--;
				if (col == (n - 1))// 如果是最后一列将列数调整为第一列
					col = 0;
				else
					col++;
			}
		}

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				System.out.print(magic[i][j] + "\t");
			    System.out.println();
		}
        try {
		File ff = new File("src/P1/txt/6.txt");
        FileWriter wr = new FileWriter(ff.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(wr);
        for(int i0 = 0;i0<n;i0++) {
        	for(int j0 = 0;j0<n;j0++)
        		bw.write(magic[i0][j0]+"\t");
        	bw.write("\n");
        }
        bw.close();
        }
        catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		MagicSquare.generateMagicSquare(k);
		System.out.println(MagicSquare.isLegalMagic("src/P1/txt/1.txt"));
		System.out.println(MagicSquare.isLegalMagic("src/P1/txt/2.txt"));
		System.out.println(MagicSquare.isLegalMagic("src/P1/txt/3.txt"));
		System.out.println(MagicSquare.isLegalMagic("src/P1/txt/4.txt"));
		System.out.println(MagicSquare.isLegalMagic("src/P1/txt/5.txt"));
		System.out.println(MagicSquare.isLegalMagic("src/P1/txt/6.txt"));
	    s.close();

	}

}
