//Naymish Vaghela
//Programming Language Concepts
//Test 2



package Test2.Problem4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class front {

	/* Global declarations */
	/* Variables */
	static int charClass;
	static char[] lexeme = new char[100];
	static char nextChar;
	static int lexLen;
	static int token;
	static int nextToken;
	static File in_fp;
	static FileReader fr;
	static BufferedReader br;

//	/* Character classes */
//	#define LETTER 0
//	#define DIGIT 1
//	#define UNKNOWN 99
//
//	/* Token codes */
//	#define INT_LIT 10
//	#define IDENT 11
//	#define ASSIGN_OP 20
//	#define ADD_OP 21
//	#define SUB_OP 22
//	#define MULT_OP 23
//	#define DIV_OP 24
//	#define LEFT_PAREN 25
//	#define RIGHT_PAREN 26
	
	public final static int LETTER = 0;
	public final static int DIGIT = 1;
	public final static int UNKNOWN = 99;
	
	public final static int INT_LIT = 10;
	public final static int IDENT = 11;
	public final static int ASSIGN_OP = 20;
	public final static int ADD_OP = 21;
	public final static int SUB_OP = 22;
	public final static int MULT_OP = 23;
	public final static int DIV_OP = 24;
	public final static int LEFT_PAREN = 25;
	public final static int RIGHT_PAREN = 26;
	

	/******************************************************/

	/******************************************************/
	/* lookup - a function to look up operators and
	 parentheses and return the token */
	static int lookup(char ch) {
		 switch (ch) {
			 case '(':
				 addChar();
				 nextToken = LEFT_PAREN;
				 break;
			 case ')':
				 addChar();
				 nextToken = RIGHT_PAREN;
				 break;
			 case '+':
				 addChar();
				 nextToken = ADD_OP;
				 break;
			 case '-':
				 addChar();
				 nextToken = SUB_OP;
				 break;
			 case '*':
				 addChar();
				 nextToken = MULT_OP;
				 break;
			 case '/':
				 addChar();
				 nextToken = DIV_OP;
				 break;
			 default:
				 addChar();
				 nextToken = -1;
				 break;
		 }
		 return nextToken;
	}

	/******************************************************/
	 /* addChar - a function to add nextChar to lexeme */
	static void addChar() {
		if (lexLen <= 98) {
			lexeme[lexLen++] = nextChar;
			lexeme[lexLen] = '\0';
		} else
		System.out.println("Error - lexeme is too long \n");
	}


	/**
	 * @throws IOException ****************************************************/
	 /* getChar - a function to get the next character of
	 input and determine its character class */
	static void getChar() throws IOException {
		 if ((nextChar = (char) br.read()) != -1) {
			 if (Character.isLetter(nextChar))
			 	charClass = LETTER;
			 else if (Character.isDigit(nextChar))
			 	charClass = DIGIT;
			 else
			 	charClass = UNKNOWN;
		 } else
		 	charClass = -1;
	}


	/**
	 * @throws IOException ****************************************************/
	 /* getNonBlank - a function to call getChar until it
	 returns a non-whitespace character */
	static void getNonBlank() throws IOException {
		while (Character.isWhitespace(nextChar))
		getChar();
	}

	/**
	 * @throws IOException ****************************************************/
	 /* lex - a simple lexical analyzer for arithmetic
	 expressions */
	static int lex() throws IOException {
		 lexLen = 0;
		 getNonBlank();
		 switch (charClass) {
			/* Identifiers */
			 case LETTER:
				 addChar();
				 getChar();
				 while (charClass == LETTER || charClass == DIGIT) {
					 addChar();
					 getChar();
				 }
				 nextToken = IDENT;
				 break;
			/* Integer literals */
			 case DIGIT:
				 addChar();
				 getChar();
				 while (charClass == DIGIT) {
					 addChar();
					 getChar();
				 }
				 nextToken = INT_LIT;
			 	break;
			/* Parentheses and operators */
			 case UNKNOWN:
				 lookup(nextChar);
				 getChar();
				 break;
				/* EOF */
			case -1:
				 nextToken = -1;
				 lexeme[0] = 'E';
				 lexeme[1] = 'O';
				 lexeme[2] = 'F';
				 lexeme[3] = '\0';
			 	break;
		 } /* End of switch */
		 System.out.println("Next token is: " + nextToken + " Next lexeme is + " + lexeme + "\n");
		 return nextToken;
	} /* End of function lex */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in_fp = new File("front.in");
		fr = new FileReader(in_fp);
		br = new BufferedReader(fr);
	 	getChar();
		 do {
		 	lex();
		 } while (nextToken != -1);
			

	}

}
