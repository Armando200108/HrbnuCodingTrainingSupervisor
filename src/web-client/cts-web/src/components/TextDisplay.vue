<template>
  <div class="text-display">
    <h2 class="problem-title">1. 重复元素</h2>
    <div class="tags">
      <el-tag type="success"style="margin: 0px 5px">简单</el-tag>
      <el-tag type="success"style="margin: 0px 5px">已通过</el-tag>
      <i class="el-icon-s-promotion"  style="font-size: 30px;margin: 0px 5px;"></i>
    </div>
    <div style="margin: 5px 5px;color: #909399;">本试题支持C、C++、Java判题，时间限制：1000 ms，空间限制：256MB。</div>
    <el-divider></el-divider>
    <div class="problem-content">
      <p>给定一个整数数组，判断是否存在重复元素。</p>
      <p>如果任意一值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。</p>
      <p>示例 1:</p>
      <p>输入: [1,2,3,1]</p>
      <p>输出: true</p>
      <p>示例 2:</p>
      <p>输入: [1,2,3,4]</p>
      <p>输出: false</p>
      <p>示例 3:</p>
      <p>输入: [1,1,1,3,3,4,3,2,4,2]</p>
      <p>输出: true</p>
      <p>给定一个整数数组，判断是否存在重复元素。</p>
      <p>如果任意一值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。</p>
      <p>示例 1:</p>
      <p>输入: [1,2,3,1]</p>
      <p>输出: true</p>
      <p>示例 2:</p>
      <p>输入: [1,2,3,4]</p>
      <p>输出: false</p>
      <p>示例 3:</p>
      <p>输入: [1,1,1,3,3,4,3,2,4,2]</p>
      <p>输出: true</p>
      <p>给定一个整数数组，判断是否存在重复元素。</p>
      <p>如果任意一值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。</p>
      <p>示例 1:</p>
      <p>输入: [1,2,3,1]</p>
      <p>输出: true</p>
      <p>示例 2:</p>
      <p>输入: [1,2,3,4]</p>
      <p>输出: false</p>
      <p>示例 3:</p>
      <p>输入: [1,1,1,3,3,4,3,2,4,2]</p>
      <p>输出: true</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "TextDisplay"
}
</script>

<style scoped>
.tags{
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: flex-start;
  align-content: center;
}

.text-display{
  padding: 10px 30px;
  overflow: scroll;
  max-height: 100%;
}

.problem-title{
  color: #303133;
}

.problem-content{
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  color: #606266;
  font-size: 16px;
}
</style>
