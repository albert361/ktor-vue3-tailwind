<script setup>
import { onMounted, ref } from "vue";

const state = ref({ content: undefined });

onMounted(async () => {
  state.value.content = (await fetch("/api").then((r) => r.json())).content;
});
</script>

<template>
  <h1 class="text-xl font-bold underline">
    About with TailWind CSS {{ state.content }}
  </h1>
</template>
