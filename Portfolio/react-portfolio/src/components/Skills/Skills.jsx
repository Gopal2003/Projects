import React from 'react'
import skills from '../../Data/Skills.json'
import { getImageUrl } from '../../utils'
import styles from './Skills.module.css'

const Experience = () => {
    return (
        <section className={styles.container} id='experience'>
            <h2 className={styles.title}>Skills</h2>
            <div className={styles.content}>
                <div className={styles.skills}>{
                    skills.map((skill, id) => {
                        return <div key={id} className={styles.skill}>
                            <div className={styles.skillImageContainer}>
                                <img src={getImageUrl(skill.imageSrc)} alt={skill.title} />
                            </div>
                            <p>{skill.title}</p>
                        </div>
                    })
                }</div>
                <ul>
                    {/* Experiences , Same syntax as skills*/}
                </ul>
            </div>

        </section>
    )
}

export default Experience