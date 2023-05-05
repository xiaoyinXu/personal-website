import {ref} from "vue";

export function randomInt(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1) + min)
}

export function randomOne<T>(list: Array<T>): T | null {
    if (!list || list.length === 0) {
        return null
    }
    return list[randomInt(0, list.length - 1)]
}