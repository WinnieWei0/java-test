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
      <el-form-item label="type" :label-width="formLabelWidth">
        <el-input v-model="form.type" autocomplete="true" :disable="dialogType== 'view'"/>
      </el-form-item>
      <el-form-item label="name" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="off"  :disable="dialogType== 'view'"/>
      </el-form-item>
      <el-form-item label="description" :label-width="formLabelWidth">
        <el-input v-model="form.description" autocomplete="off"  :disable="dialogType== 'view'"/>
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
import useAxios from '@/utils/useAxios';

interface Book {
      id?: string
      type: string
      name: string
      description: string
}
let tableData = ref<Array<Book>>()
const dialogFormVisible = ref(false)
const formLabelWidth = ref('120px')
const form = ref({
  type:'',
  name: '',
  description: '',
})
const title = ref('Add Book')
const dialogType = ref('add')
const axios=useAxios()


const handleAdd = () => {
  dialogFormVisible.value = true
  title.value = 'Add Book'
  dialogType.value= 'add'
  form.value={
  type:'',
  name: '',
  description: '',
}
}
const handleView = (row:any) => {
  dialogFormVisible.value = true
  title.value = 'View Book'
  dialogType.value= 'view'
  form.value=row
}
const handleEdit = (row:any) => {
  dialogFormVisible.value = true
  title.value = 'Edit Book'
  dialogType.value= 'edit'
  form.value=row
}
const handleDelete = (row:any) => {
  dialogType.value= 'delete'
  form.value=row
}
const handleSubmit = () => {
  let requast='/books'
  dialogFormVisible.value = false
}

// created
const getList = () => {
  axios.get('/api/books').then((res:any)=>{
    console.log(222,res)
  }).catch((err:any)=>{
    console.log('/api/books',err)
  })
}
getList()
</script>

<style></style>
