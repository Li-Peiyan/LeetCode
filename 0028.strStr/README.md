# 28. 实现 strStr()
实现 strStr() 函数。

给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。


## ***Knuth-Morris-Pratt 算法***

***KMP***

计算每个字母处与开头的最长匹配
