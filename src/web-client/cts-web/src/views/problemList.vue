<template>
  <div id="problemList">
    <div class="header-buttons">
      <el-select
        id="tag_select"
        v-model="value2"
        style="width: 20vw;margin: 10px 10px;"
        multiple
        collapse-tags
        placeholder="标签">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      <el-input
        id="search_input"
        style="width: 20vw;margin: 10px 10px"
        placeholder="搜索题目"
        prefix-icon="el-icon-search"
        clearable
        v-model="input2">
      </el-input>
    </div>

    <el-table
      ref="filterTable"
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="index"
        label="序号"
        sortable
        width="80"
        column-key="date"
        :sort-method="sort_index"
      >
      </el-table-column>
      <el-table-column
        prop="name"
        label="题目">
      </el-table-column>
      <el-table-column
        prop="difficulty"
        label="难度"
        width="100">
        <template slot-scope="scope">
          <el-tag type="warning" v-if="scope.row.difficulty ==3">中等</el-tag>
          <el-tag type="success" v-else-if="scope.row.difficulty<3">简单</el-tag>
          <el-tag type="danger" v-else>困难</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="passingRate"
        label="通过率"
        :formatter="formatter"
        width="100">
      </el-table-column>
      <el-table-column
        prop="state"
        label="状态"
        width="100"
        :filters="[{ text: '已通过', value: '已通过' }, { text: '尝试过', value: '尝试过' }, { text: '未尝试', value: '未尝试' }]"
        :filter-method="filterTag"
        filter-placement="bottom-end">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.tag === '已通过' ? 'success' : scope.row.tag === '尝试过'?'warning':'info'"
            disable-transitions>{{ scope.row.tag }}
          </el-tag>
        </template>
      </el-table-column>
    </el-table>
    <div class="page-pagination">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage2"
        :page-sizes="[20,50,100]"
        :page-size="20"
        layout="sizes, prev, pager, next"
        :total="1000">
      </el-pagination>
    </div>

  </div>
</template>

<script>
export default {
  name: "problemList",
  data() {
    return {
      tableData: [
        {
          index: '1',
          name: '两数之和',
          difficulty: '1',
          passingRate: '52.9',
          tag: '已通过'
        }, {
          index: '2',
          name: '两数相加',
          difficulty: '3',
          passingRate: '42.4',
          tag: '尝试过'
        }, {
          index: '3',
          name: '无重复字符的最长子串',
          difficulty: '4',
          passingRate: '39.1',
          tag: '未尝试'
        }, {
          index: '4',
          name: '寻找两个正序数组的中位数',
          difficulty: '3',
          passingRate: '41.7',
          tag: '已通过'
        }, {
          index: '5',
          name: '最长回文子串',
          difficulty: '3',
          passingRate: '37.5',
          tag: '已通过'
        }, {
          index: '6',
          name: 'N 字形变换',
          difficulty: '3',
          passingRate: '52.0',
          tag: '已通过'
        }, {
          index: '7',
          name: '整数反转',
          difficulty: '3',
          passingRate: '35.4',
          tag: '已通过'
        }, {
          index: '8',
          name: '字符串转换整数 (atoi)',
          difficulty: '3',
          passingRate: '21.3',
          tag: '已通过'
        }, {
          index: '9',
          name: '回文数',
          difficulty: '3',
          passingRate: '56.1',
          tag: '已通过'
        }, {
          index: '10',
          name: '正则表达式匹配',
          difficulty: '3',
          passingRate: '30.8',
          tag: '已通过'
        }, {
          index: '11',
          name: '盛最多水的容器',
          difficulty: '3',
          passingRate: '60.4',
          tag: '已通过'
        }, {
          index: '12',
          name: '整数转罗马数字',
          difficulty: '3',
          passingRate: '66.2',
          tag: '已通过'
        }, {
          index: '13',
          name: '罗马数字转整数',
          difficulty: '3',
          passingRate: '62.1',
          tag: '已通过'
        }, {
          index: '14',
          name: '最长公共前缀',
          difficulty: '3',
          passingRate: '43.2',
          tag: '已通过'
        }, {
          index: '15',
          name: '三数之和',
          difficulty: '3',
          passingRate: '36.9',
          tag: '已通过'
        }, {
          index: '16',
          name: '最接近的三数之和',
          difficulty: '3',
          passingRate: '45.0',
          tag: '已通过'
        }, {
          index: '17',
          name: '电话号码的字母组合',
          difficulty: '3',
          passingRate: '58.0',
          tag: '已通过'
        }, {
          index: '18',
          name: '四数之和',
          difficulty: '3',
          passingRate: '37.1',
          tag: '已通过'
        }, {
          index: '19',
          name: '删除链表的倒数第 N 个结点',
          difficulty: '3',
          passingRate: '45.4',
          tag: '已通过'
        }, {
          index: '20',
          name: '有效的括号',
          difficulty: '3',
          passingRate: '44.2',
          tag: '已通过'
        }
      ],
      options: [{
        value: '1',
        label: '贪心'
      }, {
        value: '2',
        label: '动态规划'
      }, {
        value: '3',
        label: '测试'
      }],
      value1: [],
      value2: []
    }
  },
  methods: {
    resetDateFilter() {
      this.$refs.filterTable.clearFilter('date');
    },
    clearFilter() {
      this.$refs.filterTable.clearFilter();
    },
    formatter(row, column) {
      return row.passingRate + '%';
    },
    filterTag(value, row) {
      return row.tag === value;
    },
    filterHandler(value, row, column) {
      const property = column['property'];
      return row[property] === value;
    },
    sort_index(a, b) {
      return a.index - b.index;
    }
  }
}
</script>

<style scoped>
.page-pagination {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}

.header-buttons{
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
  flex-wrap: wrap;
}
/*#search_input{*/
/*  width: 20vw;*/
/*  margin:5px 10px;*/
/*  flex-grow: 1;*/
/*}*/
/*#tag_select{*/
/*  width: 100%;*/
/*  margin:5px 10px;*/
/*  flex-grow: 1;*/
/*}*/
/*@media (min-width: 768px) {*/
/*  #search_input {*/
/*    width: 20vw;*/
/*    margin:5px 10px;*/
/*    flex-grow: 1;*/
/*  }*/
/*}*/
/*@media (min-width: 768px) {*/
/*  #tag_select{*/
/*    width: 20vw;*/
/*    margin:5px 10px;*/
/*    flex-grow: 1;*/
/*  }*/
/*}*/
</style>
