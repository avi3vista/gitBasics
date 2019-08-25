package com.experiment;

import java.awt.SystemColor;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {
    public static void main(String args[] ) throws Exception {
        //First the input needs to be read and stored in a string list
        List<String> inputStringList = new ArrayList<String>();
        inputStringList.add("/user userRootEndpoint");
        inputStringList.add("/user/friends userFriendsEndpoint");
        inputStringList.add("/user/lists userListsEndpoint");
        inputStringList.add("/user/X userEndpoint");
        inputStringList.add("/user/X/friends userFriendsEndpoint");
        inputStringList.add("/user/X/lists userListsEndpoint");
        inputStringList.add("/user/X/lists/X userListIdEndpoint");
        inputStringList.add("/ rootEndpoint");
        inputStringList.add("/X/friends userFriendsEndpoint");
        inputStringList.add("/X/lists userListsEndpoint");
        inputStringList.add("/settings settingsEndpoint");
        inputStringList.add("# end of configuration, request paths to follow (this line is a comment, do not assume it will always be the same)");
        inputStringList.add("/user");
        inputStringList.add("/user/friends");
        inputStringList.add("/user/123");
        inputStringList.add("/user/123/friends");
        inputStringList.add("/user/123/friends/zzz");
        inputStringList.add("/user/friends/friends");
        inputStringList.add("/");
        inputStringList.add("/abc/lists");
        inputStringList.add("/settings");
        inputStringList.add("/aaa/bbb");
        
        
        
        //Prepare a trie of configuration based on inputStringList till the string starts with #

        //trie structure is a list of string and its name to identify node;
        TrieNode root = new TrieNode("/");
        int i =0;
        for(i=0; i<inputStringList.size(); i++) {
            if(inputStringList.get(i).startsWith("#")) {
                break;
            }
            String[] currSplit = inputStringList.get(i).split(" ");
            String[] pathSplit = currSplit[0].split("/");
            insertIntoTrie(root, pathSplit, currSplit[1]);
           
        }


        i++;
        for(;i<inputStringList.size();i++) {
            System.out.println(getRequestConfigName(inputStringList.get(i),root));
        }



    }

    private static String getRequestConfigName(String s, TrieNode root) {
        String configName="404";

        String[] curSplit = s.split("/");
        if(curSplit.length==0) {
            return root.configName;
        }
       
        TrieNode currentNode = root;
        boolean[] isPresent = new boolean[1];
        TrieNode[] foundNode = new TrieNode[1];
        dfsFindNode(root, curSplit, 1, isPresent, foundNode);
        if(isPresent[0]) {
            return foundNode[0].getConfigName();

        }
        

        return configName;
    }

    public static void dfsFindNode (TrieNode root, String[] curString, int i, boolean[] isPresent, TrieNode[] foundNode) {
        
        if(i==curString.length) {
            isPresent[0]=true;
            foundNode[0]=root;
            return;
        }
        if(root.getChildren().containsKey(curString[i])) {
             dfsFindNode(root.getChildren().get(curString[i]), curString, i+1, isPresent,foundNode);
        }
        if (!isPresent[0] && root.getChildren().containsKey("X")) {
             dfsFindNode(root.getChildren().get("X"), curString, i + 1, isPresent,foundNode);
        }
        

        return;
    }

    private static void insertIntoTrie(TrieNode root, String[] s, String configName) {
        TrieNode currentNode = root;
        for (int i=1; i<s.length; i++) {
            currentNode = insertChild(s[i], currentNode);
        }
        currentNode.setEndAlso(true);
        currentNode.setConfigName(configName);

    }

    private static TrieNode insertChild(String s, TrieNode currentNode) {
        if (!currentNode.getChildren().containsKey(s)) {
            currentNode.getChildren().put(s, new TrieNode(s));
        }

        return currentNode.getChildren().get(s);
    }


    static class TrieNode {
        String curStr;
        Map<String, TrieNode> children = new HashMap<String, TrieNode>();
        boolean isEndAlso;
        String configName;

        public TrieNode(String c, Map<String, TrieNode> children, boolean isEndAlso, String configName) {
            super();
            this.curStr = c;
            this.children = children;
            this.isEndAlso = isEndAlso;
            this.configName = configName;
        }

        public Map<String, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(Map<String, TrieNode> children) {
            this.children = children;
        }

        public boolean isEndAlso() {
            return isEndAlso;
        }

        public void setEndAlso(boolean isEndAlso) {
            this.isEndAlso = isEndAlso;
        }

        public String getCurStr() {
            return this.curStr;
        }

        public void setCurStr(String cs) {
            this.curStr = cs;
        }


        public String getConfigName() {
            return this.configName;
        }

        public void setConfigName(String configName) {
            this.configName = configName;
        }

        public TrieNode() {
            super();
        }

        public TrieNode(String c, String configName) {
            this.curStr = c;
            this.children = new HashMap<String, TrieNode>();
            this.isEndAlso = false;
            this.configName= configName;
        }

        public TrieNode(String c) {
            this.curStr = c;
            this.children = new HashMap<String, TrieNode>();
            this.isEndAlso = false;
        }

        public TrieNode(String c, boolean isEndAlso, String configName) {
            this.curStr = c;
            this.children = new HashMap<String, TrieNode>();
            this.isEndAlso = isEndAlso;
            this.configName = configName;
        }

        @Override
        public String toString() {

            StringBuffer s = new StringBuffer();
            s.append("< value = " + this.curStr + "   ChildrenList = " + this.children + "  Is End = " + this.isEndAlso + " configName = " + this.configName 
                    + " >");
            return s.toString();
        }

    }
}

