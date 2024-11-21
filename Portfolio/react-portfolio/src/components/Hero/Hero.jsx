import React from 'react'
import styles from './Hero.module.css';
import { getImageUrl } from '../../utils';

const Hero = () => {
    return <section className={styles.container}>
        <div className={styles.content}>
            <h1 className={styles.title}>Hi, I'm Gopal Agarwal</h1>
            <p className={styles.description}>
                An aspiring software engineer with the ability to grow as an individual and learn in the surrounding of talented people.
            </p>
            <a href="mailto:gopalmittal2003@gmail.com" className={styles.contactBtn}>Hire Me!</a>
        </div>
        <img src={getImageUrl("hero/HeroImage1.png")} alt="Hero Image of Me" className={styles.heroImg} />
        <div className={styles.topBlur} />
        <div className={styles.bottomBlur} />
    </section>
}

export default Hero