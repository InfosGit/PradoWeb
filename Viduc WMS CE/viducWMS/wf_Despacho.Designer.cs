namespace viducWMS
{
    partial class wf_Despacho
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.cmbEstadoProforma = new System.Windows.Forms.ComboBox();
            this.dgProformas = new System.Windows.Forms.DataGrid();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label1.ForeColor = System.Drawing.Color.Navy;
            this.label1.Location = new System.Drawing.Point(4, 6);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(66, 18);
            this.label1.Text = "Proformas:";
            // 
            // cmbEstadoProforma
            // 
            this.cmbEstadoProforma.Location = new System.Drawing.Point(73, 3);
            this.cmbEstadoProforma.Name = "cmbEstadoProforma";
            this.cmbEstadoProforma.Size = new System.Drawing.Size(161, 22);
            this.cmbEstadoProforma.TabIndex = 1;
            this.cmbEstadoProforma.SelectedIndexChanged += new System.EventHandler(this.cmbEstadoProforma_SelectedIndexChanged);
            // 
            // dgProformas
            // 
            this.dgProformas.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            this.dgProformas.Location = new System.Drawing.Point(4, 28);
            this.dgProformas.Name = "dgProformas";
            this.dgProformas.Size = new System.Drawing.Size(230, 229);
            this.dgProformas.TabIndex = 5;
            this.dgProformas.DoubleClick += new System.EventHandler(this.dgProformas_DoubleClick);
            this.dgProformas.KeyUp += new System.Windows.Forms.KeyEventHandler(this.dgProformas_KeyUp);
            // 
            // btnCancelar
            // 
            this.btnCancelar.BackColor = System.Drawing.Color.Navy;
            this.btnCancelar.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.btnCancelar.ForeColor = System.Drawing.Color.White;
            this.btnCancelar.Location = new System.Drawing.Point(145, 261);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(89, 30);
            this.btnCancelar.TabIndex = 9;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // wf_Despacho
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.Controls.Add(this.btnCancelar);
            this.Controls.Add(this.dgProformas);
            this.Controls.Add(this.cmbEstadoProforma);
            this.Controls.Add(this.label1);
            this.Name = "wf_Despacho";
            this.Text = "Despacho";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cmbEstadoProforma;
        private System.Windows.Forms.DataGrid dgProformas;
        private System.Windows.Forms.Button btnCancelar;
    }
}