
public class FindTheWordInMatrix{
	static int row=8,col=7;
	static String word="hello";
	static char matrix[][]=
		{{'c','h','e','l','l','o','z'},
				{'o','e','e','e','o','e','h'},
				{'i','l','o','l','l','o','o'},
				{'n','l','a','c','l','d','l'},
				{'d','o','l','l','e','o','l'},
				{'i','n','e','l','h','m','e'},
				{'a','h','i','i','e','y','h'},
				{'h','k','i','l','l','h','r'}};
	private static void searchMatrix(int i, int j) {
		int r=i,c=j,currIndex=0;
		String output = "";
		//Left
		r=i;c=j;currIndex=0;output = "";
		if((c+1)>=word.length()){
			for(int a=0;a<word.length();a++){
				if(matrix[r][c]==word.charAt(currIndex)){
					output+="("+r+","+c+")"+matrix[r][c]+" ";
					c--;currIndex++;
				}else{
					output = null;
					break;
				}
			}
			if(output != null)System.out.println(output);
		}
		//Right
		r=i;c=j;currIndex=0;output="";
		if((col-c)>=word.length()){
			for(int a=0;a<word.length();a++){
				if(matrix[r][c]==word.charAt(currIndex)){
					output+="("+r+","+c+")"+matrix[r][c]+" ";
					c++;currIndex++;
				}else{
					output=null;
					break;
				}
			}
			if(output != null)System.out.println(output);
		}
		//Down
		r=i;c=j;currIndex=0;output="";
		if((row-(r+1))>=word.length()){
			for(int a=0;a<word.length();a++){
				if(matrix[r][c]==word.charAt(currIndex)){
					output+="("+r+","+c+")"+matrix[r][c]+" ";
					r++;currIndex++;
				}else{
					output=null;
					break;
				}
			}
			if(output != null)System.out.println(output);
		}
		//Up
		r=i;c=j;currIndex=0;output="";
		if((r+1)>=word.length()){
			for(int a=0;a<word.length();a++){
				if(matrix[r][c]==word.charAt(currIndex)){
					output+="("+r+","+c+")"+matrix[r][c]+" ";
					r--;currIndex++;
				}else{
					output=null;
					break;
				}
			}
			if(output != null)System.out.println(output);
		}
		//LeftUp
		r=i;c=j;currIndex=0;output="";
		if((c+1)>=word.length()&&(r+1)>=word.length()){
			for(int a=0;a<word.length();a++){
				if(matrix[r][c]==word.charAt(currIndex)){
					output+="("+r+","+c+")"+matrix[r][c]+" ";
					r--;c--;currIndex++;
				}else{
					output=null;
					break;
				}
			}
			if(output != null)System.out.println(output);
		}
		//LeftDown
		r=i;c=j;currIndex=0;output="";
		if((c+1)>=word.length()&&(row-(r+1))>=word.length()){
			for(int a=0;a<word.length();a++){
				if(matrix[r][c]==word.charAt(currIndex)){
					output+="("+r+","+c+")"+matrix[r][c]+" ";
					r++;c--;currIndex++;
				}else{
					output=null;
					break;
				}
			}
			if(output != null)System.out.println(output);
		}
		//RightUP
		r=i;c=j;currIndex=0;output="";
		if((col-c)>=word.length()&&(r+1)>=word.length()){
			for(int a=0;a<word.length();a++){
				if(matrix[r][c]==word.charAt(currIndex)){
					output+="("+r+","+c+")"+matrix[r][c]+" ";
					r--;c++;currIndex++;
				}else{
					output=null;
					break;
				}
			}
			if(output != null)System.out.println(output);
		}
		//RightDown
		r=i;c=j;currIndex=0;output="";
		if((col-c)>=word.length()&&(row-(r+1))>=word.length()){
			for(int a=0;a<word.length();a++){
				if(matrix[r][c]==word.charAt(currIndex)){
					output+="("+r+","+c+")"+matrix[r][c]+" ";
					r++;c++;currIndex++;
				}else{
					output=null;
					break;
				}
			}
			if(output != null)System.out.println(output);
		}
	}
	public static void main(String args[]){		
		char start=word.charAt(0);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				if(start==matrix[i][j]){
					searchMatrix(i,j);
				}
			}
		}
	}
}
