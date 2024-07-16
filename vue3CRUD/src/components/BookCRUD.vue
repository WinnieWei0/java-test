<template>
  <el-button type="primary" size="small" @click="handleAdd">
          新增
        </el-button>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column prop="id" label="Date" width="180" />
    <el-table-column prop="name" label="Name" width="180" />
    <el-table-column prop="author" label="Author" />
    <el-table-column fixed="right" label="Operations" width="200">
      <template #default="{row}">
        <el-button link type="primary" size="small" @click="handleView(row)">
          查看
        </el-button>
        <el-button link type="primary" size="small" @click="handleEdit(row)">编辑</el-button>
        <el-button link type="primary" size="small" @click="handleDelete(row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog v-model="dialogFormVisible" :title="title" width="500">
    <el-form :model="form">
      <el-form-item label="name" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="true" />
      </el-form-item>
      <el-form-item label="author" :label-width="formLabelWidth">
        <el-input v-model="form.author" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="handleSubmit">
          Confirm
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref } from 'vue'

let tableData = ref<Array<{
      id?: string
      name: string
      author: string
    }>>()
const dialogFormVisible = ref(false)
const formLabelWidth = ref('120px')
const form = ref({
  name: '',
  author: '',
})
const title = ref('Add Book')

const handleAdd = () => {
  dialogFormVisible.value = true
  title.value = 'Add Book'
  console.log('add')
}
const handleView = (row:any) => {
  dialogFormVisible.value = true
  title.value = 'View Book'
  console.log('view',row,row.id)
}
const handleEdit = (row:any) => {
  dialogFormVisible.value = true
  title.value = 'Edit Book'
  console.log('edit',row)
}
const handleDelete = (row:any) => {
  console.log('delete',row)
}
const handleSubmit = () => {
  console.log('submit')
  dialogFormVisible.value = false
}

// created
const getList = () => {
  tableData.value = [
    { id: '1', name: 'Vue3', author: 'Evan' },
    { id: '2', name: 'React', author: 'Jordan' },
    { id: '3', name: 'Angular', author: 'Google' },
  ]
}
getList()
</script>

<style></style>
